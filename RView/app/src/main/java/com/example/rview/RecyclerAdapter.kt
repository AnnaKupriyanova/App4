package com.example.rview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val context: Context,
                      private val colorsList: ArrayList<MainActivity.ColorData>,
                      private val cellClickListener: CellClickListener) : RecyclerView
.Adapter<RecyclerAdapter.MyViewHolder>() {

    interface CellClickListener {
        fun onCellClickListener(data: String)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.textViewColor)
        val hex: View = itemView.findViewById(R.id.viewColor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = colorsList[position].colorName
        holder.hex.setBackgroundColor(colorsList[position].colorHex)

        val data = colorsList[position].colorName
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data)
        }
    }

    override fun getItemCount() = colorsList.size
}