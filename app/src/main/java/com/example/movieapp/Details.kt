package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve URL and description from intent extras
        val url = intent.getStringExtra("URL")
        val description = intent.getStringExtra("DESC")
        val runtime = intent.getStringExtra("RUNTIME")
        val  year = intent.getStringExtra("YEAR")
        val imbdrating = intent.getStringExtra("IMBDRATING")
        val genre = intent.getStringExtra("GENRE")
        val languages = intent.getStringExtra("LANGUAGE")
        val img1 = intent.getStringExtra("IMG1")
        val img2= intent.getStringExtra("IMG2")
        val img3= intent.getStringExtra("IMG3")
        val img4= intent.getStringExtra("IMG4")
        val actors= intent.getStringExtra("ACTORS")
        val director= intent.getStringExtra("DIRECTOR")
        val writer= intent.getStringExtra("WRITER")
        val avards= intent.getStringExtra("AVARDS")


        binding.detailDescription.text = description
        Glide.with(this).load(url).centerCrop().into(binding.detailImg)
        binding.detailGenre.text = genre
        binding.detailImdb.text= imbdrating
        binding.detailReleased.text= year
        binding.detailDuration.text=runtime
        binding.detailLanguages.text=languages
        Glide.with(this).load(img1).centerCrop().into(binding.img1)
        Glide.with(this).load(img2).centerCrop().into(binding.img2)
        Glide.with(this).load(img3).centerCrop().into(binding.img3)
        Glide.with(this).load(img4).centerCrop().into(binding.img4)
        binding.detailAwards.text= avards
        binding.detailCast.text=actors
        binding.detailDirector.text = director
        binding.detailWriter.text=writer

    }
}