package com.example.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.countries.api.NetworkClient
import com.example.example.Country
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        val networkClient = NetworkClient()
        val call = networkClient.getCountries()

        call.enqueue(object : Callback<ArrayList<Country>> {
            override fun onResponse(
                call: Call<ArrayList<Country>>,
                response: Response<ArrayList<Country>>
            ) {
                val countries = response.body()
                if (countries != null) {
                    val countryNames = countries.map { it.name?.common }
                    val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, countryNames)
                    listView.adapter = adapter

                    listView.setOnItemClickListener { _, _, position, _ ->
                        val selectedCountry = countries[position]
                        val intent = Intent(this@MainActivity, CountryDetailActivity::class.java)
                        intent.putExtra("selected_country", selectedCountry)
                        startActivity(intent)
                    }

                }
            }

            override fun onFailure(call: Call<ArrayList<Country>>, t: Throwable) {
            }
        })
    }
}