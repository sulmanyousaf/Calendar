package com.sulman.calendar.data.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulman.calendar.data.model.ListItemModel
import com.sulman.calendar.databinding.ListItemBinding

class ListItemAdapter(private val listItem: List<ListItemModel>) :
    RecyclerView.Adapter<ListItemAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size

    class ImageViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ListItemModel) {
            binding.apply {
                Log.d("imageloading", "bind:${item.icon} ")
                ivItem.setImageResource(item.icon)
                tvTitle.text = item.title.orEmpty()
                tvPrice.text = item.price.orEmpty()
            }
        }
    }
}