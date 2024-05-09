package com.example.api

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.api.databinding.ActivityDescriptionBinding
import com.squareup.picasso.Picasso

class Description : AppCompatActivity() {
    lateinit var binding: ActivityDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this@Description,R.layout.activity_description)
        with(binding){
            val title=intent.getStringExtra("title")
            val description=intent.getStringExtra("description")
            val image=intent.getStringExtra("image")

            dpProductTitle.text=title
            productDes.text=description
            Picasso.get().load(image).into(dpProductPic)
        }

    }
}