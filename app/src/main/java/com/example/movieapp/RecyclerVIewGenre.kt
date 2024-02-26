package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import retrofit2.Callback

class MyviewHolder(itemView: View): ViewHolder(itemView){
    private val Genre: TextView = itemView.findViewById(R.id.genretext);
    private val nestedrv: RecyclerView = itemView.findViewById(R.id.nestedrv)

    fun bind(genre: String,genremovielist:ArrayList<Movie>, listner: OnGenreItemClicked,itemClickListener: OnMovieItemClickListener){
        Genre.text = genre
       nestedrv.layoutManager = LinearLayoutManager(itemView.context,RecyclerView.HORIZONTAL,false)
        nestedrv.adapter = NestedAdapter(genremovielist,itemClickListener)

        itemView.setOnClickListener {
            listner.OnitemClicked(genre)
        }
    }
}

 class Myadpater(private val genres: HashMap<String,ArrayList<Movie>>,
 private val listner: OnGenreItemClicked,private val itemClickListener: OnMovieItemClickListener): Adapter<MyviewHolder> (){
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
         val view = LayoutInflater.from(parent.context)
             .inflate(R.layout.main_item,parent,false)
         return MyviewHolder(view)
     }

     override fun getItemCount(): Int {
        return genres.size
     }

     override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
         val genreList = genres.keys.toList()
         val genremovielist = genres.values.toList()

         val genret = genreList[position]
         val genrem = genremovielist[position]
         holder.bind(genret,genrem,listner, itemClickListener )
     }

 }
class NestedviewHolder(itemView: View): ViewHolder(itemView){
    private val name: TextView = itemView.findViewById(R.id.movie_name)
    private val image: ImageView = itemView.findViewById(R.id.movie_img)
    fun nestedbind(moviename: Movie,itemClickListener: OnMovieItemClickListener){
        name.text = moviename.title
        Glide.with(itemView.context).load(moviename.poster.toString()).centerCrop().placeholder(R.mipmap.ic_launcher) // Placeholder image while loading
            .error(R.mipmap.ic_launcher).into(image)

        itemView.setOnClickListener {
            itemClickListener.onMovieItemClick(moviename)
        }


    }
}
class NestedAdapter(
    private  val movielist :ArrayList<Movie>, private val itemClickListener: OnMovieItemClickListener): Adapter<NestedviewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedviewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item,parent,false)
        return NestedviewHolder(view)
    }

    override fun getItemCount(): Int {
       return movielist.size
    }

    override fun onBindViewHolder(holder: NestedviewHolder, position: Int) {
        val movieitem = movielist[position]
        holder.nestedbind(movieitem,itemClickListener)
    }

}

interface OnGenreItemClicked{
    fun OnitemClicked(genre: String)
}

interface OnMovieItemClickListener {
    fun onMovieItemClick(movie: Movie)
}

