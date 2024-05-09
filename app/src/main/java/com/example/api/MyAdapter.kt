package com.example.api

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.telecom.Call.Details
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter (val context: Activity, val productArrayList:List<Product>):
        RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var title:TextView
        var image : ShapeableImageView
        var description :TextView
        init {
            title=itemView.findViewById(R.id.productTitle)
            image=itemView.findViewById(R.id.productImage)
            //first initialise the id and give its type
            description=itemView.findViewById(R.id.productDes)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView=LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return  MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
      return  productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=productArrayList[position]
        holder.title.text=currentItem.title
        //now hold the view
        holder.description.text=currentItem.title
        //image view,how to show image in image view if we have image in url...using picassso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);


        // now set on click listener

        holder.itemView.setOnClickListener{
            val intent= Intent(context,Description::class.java)
            //pass necessasry data
            intent.putExtra("title",currentItem.title)
            intent.putExtra("image",currentItem.thumbnail)
            intent.putExtra("description",currentItem.description)
            context.startActivity(intent)

        }



    }

}