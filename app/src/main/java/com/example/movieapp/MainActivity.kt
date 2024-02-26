package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),OnGenreItemClicked , OnMovieItemClickListener{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var container: HashMap<String, ArrayList<Movie>> = HashMap()
        api.fetchDogBreeds().enqueue(object : Callback<List<Movie>?> {
            override fun onResponse(
                call: Call<List<Movie>?>,
                response: Response<List<Movie>?>
            ) {
                if(response.isSuccessful){
                    val data = response.body() ?: listOf()
                    for (d in data) {
                        val resultList = d.genre.split(",").map { it.trim() }
                        for (i in resultList) {
                            if (container[i] == null) {
                                container[i] = ArrayList()
                            }
                            val temp = container[i]
                            temp?.add(d)
                            container[i] = temp!!
                        }

                    }
                    container.forEach {
                        Log.d("printing", it.toString())
                    }
                    binding.mainrv.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                    binding.mainrv.adapter = Myadpater(container,this@MainActivity,this@MainActivity)
                }
            }

            override fun onFailure(call: Call<List<Movie>?>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Error${t.message}", Toast.LENGTH_LONG).show()
            }
        })





    }

    override fun OnitemClicked(genre: String) {
        Toast.makeText(this,"$genre",Toast.LENGTH_LONG).show()
    }

    override fun onMovieItemClick(movie: Movie) {
//        Toast.makeText(this,movie.title,Toast.LENGTH_LONG).show()
        val url: String = movie.poster
        val desc : String = movie.plot
        val runtime:String= movie.runtime
        val year:String = movie.year
        val imbdrating = movie.imdbRating
        val genre = movie.genre
        val languages = movie.languages
        val intent = Intent(this@MainActivity, Details::class.java)
        intent.putExtra("URL",url)
        intent.putExtra("DESC",desc)
        intent.putExtra("RUNTIME",runtime)
        intent.putExtra("YEAR",year)
        intent.putExtra("IMBDRATING",imbdrating)
        intent.putExtra("GENRE",genre)
        intent.putExtra("LANGUAGE",languages)
        startActivity(intent)

    }


}