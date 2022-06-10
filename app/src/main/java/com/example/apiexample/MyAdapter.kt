package com.example.apiexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(private var pictList: ArrayList<String>, private var ctx: Context) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.item_layout, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        Glide.with(ctx).load(pictList[position]).into(holder.picture)
    }

    override fun getItemCount(): Int {
        return pictList.size
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val picture: ImageView

        init {
            picture = itemView.findViewById(R.id.image_view)
        }
    }
}