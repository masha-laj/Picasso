package com.example.picasso

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdapter (private val context: Context, private val images: List<String>) :
    RecyclerView.Adapter<ItemAdapter.ImageViewHolder>() {
    class ImageViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.img)

        fun bindView(image: String) {
            Picasso.get()
                .load(image)
                .fit()
                .placeholder(R.drawable.ic_replay_black_24dp)
                .error(R.drawable.ic_error_black_24dp)
                .into(img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }
}