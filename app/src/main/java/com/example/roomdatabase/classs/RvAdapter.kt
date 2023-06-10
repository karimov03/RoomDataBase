package com.example.roomdatabase.classs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.databinding.ItemRvBinding

class RvAdapter(val list: ArrayList<User>): RecyclerView.Adapter<RvAdapter.vh>() {
    inner class vh(val itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        return vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: vh, position: Int) {
        holder.itemRvBinding.tvName.text=list[position].name
        holder.itemRvBinding.tvNumber.text=list[position].age.toString()
    }
}