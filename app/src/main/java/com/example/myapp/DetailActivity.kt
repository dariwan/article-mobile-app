package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.example.myapp.databinding.ActivityDetailBinding
import com.example.myapp.databinding.ActivityMainBinding


class DetailActivity : AppCompatActivity() {
    //inisialisasi binding
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //memanggil binding
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val data = intent.getParcelableExtra<Country>("DATA")
        binding.imgDetail.setImageResource(data?.photo!!)
        binding.tvDescriptionDetail.text = data?.description
        binding.tvNameDetail.text = data?.name


    }

}