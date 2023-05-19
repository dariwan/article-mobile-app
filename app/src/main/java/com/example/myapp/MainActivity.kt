package com.example.myapp

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvCountry : RecyclerView

    //memanggil data
    private val list = ArrayList<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvCountry = findViewById(R.id.rv_country)
        rvCountry.setHasFixedSize(true)

        //memanggil data
        list.addAll(getListHeroes())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_about_me ->{
                val moveIntent = Intent(this, AboutActivity::class.java)
                startActivity(moveIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvCountry.layoutManager = LinearLayoutManager(this)
        val listCountryAdapter = ListCountryAdapter(list)
        rvCountry.adapter = listCountryAdapter

        listCountryAdapter.setOnItemClickCallback(object : ListCountryAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Country){
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }

    private fun getListHeroes(): Collection<Country> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_desc_singkat)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listCountry = ArrayList<Country>()
        for (i in dataName.indices){
            val country = Country(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listCountry.add(country)
        }
        return listCountry
    }

}