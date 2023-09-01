package com.example.projectoangel.adapter

import android.content.Context
import android.database.DataSetObserver
import android.graphics.Bitmap
import android.media.Image
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectoangel.R

//import com.bumptech.glide.Glide

class ImageAdapter(val context: Context, val sunsetPhotos: Array<Uri>)
    : RecyclerView.Adapter<ImageAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageAdapter.MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageAdapter.MyViewHolder, position: Int) {
        val sunsetPhoto = sunsetPhotos[position]
        val imageView = holder.photoImageView

        Glide.with(context)
            .load(sunsetPhoto)
            .fitCenter()
            .centerCrop()
            .into(imageView)
    }

    override fun getItemCount(): Int {
        return sunsetPhotos.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var photoImageView: ImageView = itemView.findViewById(R.id.photo)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }
    }
}