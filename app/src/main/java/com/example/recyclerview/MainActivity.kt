package com.example.recyclerview

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ColorData(val colorName: String,
                val colorHex: Int
                )

val red = ColorData("red", Color.RED)
val black = ColorData("black", Color.BLACK)
val cyan = ColorData("cyan", Color.CYAN)
val white = ColorData("white", Color.WHITE)
val gray = ColorData("gray", Color.GRAY)
val magenta = ColorData("magenta", Color.MAGENTA)

val colors = arrayListOf(red, black, cyan, white, gray, magenta)


class Adapter(private val context: Context,
              private val list: ArrayList<ColorData>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image_view: View = view.findViewById(R.id.view)
        val color_name: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rview_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.image_view.setBackgroundColor(data.colorHex)
        holder.color_name.text = data.colorName
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rView: RecyclerView = findViewById(R.id.rView)
        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = Adapter(this, fetchList())
    }
    private fun fetchList(): ArrayList<ColorData> {
        return colors
    }
}
