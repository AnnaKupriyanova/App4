package com.example.rview

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), RecyclerAdapter.CellClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerAdapter(this, fillList(), this)
    }

    class ColorData(val colorName: String, val colorHex: Int)

    private fun fillList(): ArrayList<ColorData> {
        val data_name = this.resources.getStringArray((R.array.color_name))
        val data_hex = this.resources.getIntArray(R.array.color_hex)
        val list = arrayListOf<ColorData>()
        var count = 0

        while (count < data_name.count()) {
            list.add(ColorData(data_name[count], data_hex[count]))
            count++
        }
        return list
    }

    override fun onCellClickListener(data: String) {
        Toast.makeText(applicationContext, "It`s $data", Toast.LENGTH_SHORT).show()
    }

}