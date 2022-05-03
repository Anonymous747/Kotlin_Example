package com.example.example.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.R
import com.example.example.models.Asset

class AssetAdapter(private val context: Context, private val assets: List<Asset>) :
    RecyclerView.Adapter<AssetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val asset = assets[position]
        holder.bind(asset)
    }

    override fun getItemCount() = assets.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(asset: Asset) {
            val assetNameView = itemView.findViewById<TextView>(R.id.asset_name)
            val descriptionView = itemView.findViewById<TextView>(R.id.description_text)
            val imageView = itemView.findViewById<ImageView>(R.id.single_image_view)

            assetNameView.text = asset.name
            descriptionView.text = asset.description
            Glide.with(context).load(asset.imageUrl).into(imageView)
        }
    }
}