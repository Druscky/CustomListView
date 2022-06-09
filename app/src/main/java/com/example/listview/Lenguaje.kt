package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.listview.databinding.ItemLenguajeBinding
import java.text.FieldPosition

class Lenguaje(var nombre:String,var description:String, var icon:Int)


class LenguajesArrayAdapter(
    context: Context?,
    resource: Int,
    objects: List<Lenguaje>?
): ArrayAdapter<Lenguaje>(context!!, resource, objects!!){
        override fun getView(position: Int, convertView: View?, parent:ViewGroup):View {
            var view: View = convertView?:LayoutInflater.from(this.context)
                .inflate(R.layout.item_lenguaje, parent, false)
            val tvNombre = view.findViewById<TextView>(R.id.tvNombre)
            val tvDesc = view.findViewById<TextView>(R.id.tvDesc)
            val ivIcono = view.findViewById<ImageView>(R.id.ivIcono)
            getItem(position)?.let {
                tvNombre.text = it.nombre
                tvDesc.text = it.description
                ivIcono.setImageResource(it.icon)
            }
            return view
        }
}