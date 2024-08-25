package com.example.submissionakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCars: RecyclerView
    private val list = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCars = findViewById(R.id.rv_cars)
        rvCars.setHasFixedSize(true)

        list.addAll(getListCars())
        showRecyclerList()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }


    private fun getListCars(): ArrayList<Car> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataManufacture = resources.getStringArray(R.array.data_manufacture)
        val dataProduction = resources.getStringArray(R.array.data_production)

        val listCar = ArrayList<Car>()
        for (i in dataName.indices) {
            val car = Car(dataName[i], dataDescription[i], dataPhoto[i], dataManufacture[i], dataProduction[i])
            listCar.add(car)
        }
        return listCar
    }

    private fun showRecyclerList() {
        rvCars.layoutManager = LinearLayoutManager(this)
        val listCarAdapter = ListCarAdapter(list)
        rvCars.adapter = listCarAdapter

        listCarAdapter.setOnItemClickCallback(object : ListCarAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Car) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }




}