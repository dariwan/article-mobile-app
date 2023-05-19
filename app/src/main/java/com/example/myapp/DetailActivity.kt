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
        binding.tvNameDetail.text = data?.name

        val countryName = listOf(
               "Indonesia",
                "Malaysia",
                "Singapura",
                "Thailand",
                "Filipina",
                "Brunei Darussalam",
                "Vietnam",
                "Laos",
                "Myanmar",
                "Kamboja"
        )

        val countryThemeList = resources.getStringArray(R.array.data_description)
        binding.tvDescriptionDetail.text = when(data?.name){
            countryName[0] -> countryThemeList[0]
            countryName[1] -> countryThemeList[1]
            countryName[2] -> countryThemeList[2]
            countryName[3] -> countryThemeList[3]
            countryName[4] -> countryThemeList[4]
            countryName[5] -> countryThemeList[5]
            countryName[6] -> countryThemeList[6]
            countryName[7] -> countryThemeList[7]
            countryName[8] -> countryThemeList[8]
            countryName[9] -> countryThemeList[9]
            else -> "Country not found"
        }


    }

}