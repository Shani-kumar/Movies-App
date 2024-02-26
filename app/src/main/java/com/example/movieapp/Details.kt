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


        binding.detailDescription.text = description
        Glide.with(this).load(url).centerCrop().into(binding.detailImg)
        binding.detailGenre.text = genre
        binding.detailImdb.text= imbdrating
        binding.detailReleased.text= year
        binding.detailDuration.text=runtime
        binding.detailLanguages.text=languages

    }
}