package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyviewHolder(itemView: View): ViewHolder(itemView){
    private val Genre: TextView = itemView.findViewById(R.id.genretext);
    private val nestedrv: RecyclerView = itemView.findViewById(R.id.nestedrv)

    fun bind(genre: String,genremovielist:ArrayList<Movie> ){
        Genre.text = genre
       nestedrv.layoutManager = LinearLayoutManager(itemView.context,RecyclerView.HORIZONTAL,false)
        nestedrv.adapter = NestedAdapter(genremovielist)

    }
}

 class Myadpater(private  val genres: HashMap<String,ArrayList<Movie>>): Adapter<MyviewHolder> (){
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
         holder.bind(genret,genrem)
     }

 }
class NestedviewHolder(itemView: View): ViewHolder(itemView){
    private val name: TextView = itemView.findViewById(R.id.movie_name)
    fun nestedbind(moviename: Movie){
        name.text = moviename.title
    }
}
class NestedAdapter(private  val movielist :ArrayList<Movie>): Adapter<NestedviewHolder>() {
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
        holder.nestedbind(movieitem)
    }

}