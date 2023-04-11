package com.example.cellclicklistener

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val context: Context,
              private val list: ArrayList<MainActivity.ColorData>,
              private val cellClickListener: MainActivity) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image_view: View = view.findViewById(R.id.view)
        val color_name: TextView = view.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rview_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.image_view.setBackgroundColor(data.colorHex)
        holder.color_name.text = data.colorName

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "IT’S " + data.colorName, Toast.LENGTH_SHORT).show()
            Log.d("ADPA", "OKATY")
        }
    }
}

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rView: RecyclerView = findViewById(R.id.rView)
        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = Adapter(this, fetchList(), this)
    }

    class ColorData(val colorName: String, val colorHex: Int)

    private fun fetchList(): ArrayList<ColorData> {
        return arrayListOf(
            ColorData("WHITE", Color.WHITE),
            ColorData("BLACK", Color.BLACK),
            ColorData("BLUE", Color.BLUE),
            ColorData("RED", Color.RED),
            ColorData("MAGENTA", Color.MAGENTA)
        )
    }

    fun onCellClickListener(data: ColorData) {
        Toast.makeText(this, "IT’S " + data.colorName, Toast.LENGTH_SHORT).show()
    }
}