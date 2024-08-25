package com.example.submissionakhir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionakhir.databinding.ItemRowCarBinding

class ListCarAdapter(private val listCar: ArrayList<Car>) : RecyclerView.Adapter<ListCarAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowCarBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listCar[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listCar[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listCar.size

    class ListViewHolder(var binding: ItemRowCarBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: Car)
    }
}