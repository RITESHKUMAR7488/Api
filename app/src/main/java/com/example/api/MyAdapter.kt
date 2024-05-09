package com.example.api

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.api.databinding.EachitemBinding
import com.squareup.picasso.Picasso

class MyAdapter (val context: Activity, val productArrayList:List<Product>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class MyViewHolder(val binding: EachitemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.eachitem,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem=productArrayList[position]
        val viewHolder:MyViewHolder=holder as MyViewHolder
        viewHolder.binding.productTitle.text=currentItem.title
        Picasso.get().load(currentItem.thumbnail).into(holder.binding.productImage);

        holder.itemView.setOnClickListener{
            val intent= Intent(context,Description::class.java)
            intent.putExtra("title",currentItem.title)
            intent.putExtra("image",currentItem.thumbnail)
            intent.putExtra("description",currentItem.description)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return  productArrayList.size
    }



}