package com.example.api

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding) {
            //for retrofit api

            val retrofitBuilder = Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
            val retrofitData = retrofitBuilder.getProductData()

            retrofitData.enqueue(object : Callback<MyData?> {
                override fun onResponse(p0: Call<MyData?>, p1: Response<MyData?>) {
                    //if api call is success
                    var responseBody = p1.body()
                    val productList=responseBody?.products!!
                    val collectDataInSB=StringBuilder()

                   myAdapter=MyAdapter(this@MainActivity,productList)
                    recyclerView.adapter=myAdapter
                    recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)


                }

                override fun onFailure(p0: Call<MyData?>, p1: Throwable) {
                    // if api call is failed
                    Log.d("Main Activity", "onFailure: " + p1.message)
                }
            })

        }
    }
}
