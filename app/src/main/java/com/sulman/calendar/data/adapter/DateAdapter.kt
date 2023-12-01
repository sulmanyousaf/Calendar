package com.sulman.calendar.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulman.calendar.data.model.DateModel
import com.sulman.calendar.databinding.ItemDateCardBinding

class DateAdapter(private var dateList: List<DateModel>) : RecyclerView.Adapter<DateAdapter.DateViewHolder>() {

    class DateViewHolder(private val binding: ItemDateCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DateModel) {
            binding.apply {
                tvDate.text = item.date.orEmpty()
                tvDay.text = item.day.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view = ItemDateCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DateViewHolder(view)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(dateList[position])
    }

    override fun getItemCount() = dateList.size

    fun updateList(newDateList: List<DateModel>) {
        val oldSize = dateList.size
        dateList = newDateList
        val newSize = dateList.size
        notifyItemRangeInserted(oldSize, newSize - oldSize)
    }
}
