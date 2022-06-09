package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        //Declaración de un ListView desde un array
        val valores = arrayOf("C++", "Python", "JavaScript", "Kotlin", "Java", ".NET")
        val myAdaptadorArray = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, valores)

        //Declaración de un ListView desde un recurso
        val myAdaptadorResource = ArrayAdapter.createFromResource(this,
            R.array.leguajes ,android.R.layout.simple_list_item_activated_1)

        //Declaración de un ListView Custom
        val valoresLenguaje = mutableListOf<Lenguaje>()
        valoresLenguaje.add(Lenguaje("C", "Lenguaje procedural", R.mipmap.ic_launcher))
        valoresLenguaje.add(Lenguaje("Python", "Lenguaje Genérico", R.mipmap.ic_launcher))
        valoresLenguaje.add(Lenguaje("Kotlin", "Lenguaje Móviles", R.mipmap.ic_launcher))
        val myAdaptadorCustom = LenguajesArrayAdapter(this, R.layout.item_lenguaje, valoresLenguaje)

        b.listViewTest.adapter = myAdaptadorCustom
        //b.listViewTest.choiceMode = ListView.CHOICE_MODE_SINGLE
        b.listViewTest.choiceMode = ListView.CHOICE_MODE_MULTIPLE


        b.listViewTest.setOnItemClickListener { parent:AdapterView<*>,
                                                view: View, position:Int,
                                                id: Long ->
            val elemento = myAdaptadorResource.getItem(position) as String
            Toast.makeText(this, elemento, Toast.LENGTH_LONG).show()
        }

        b.listViewTest.setOnItemLongClickListener { parent:AdapterView<*>,
                                                    view: View, pos:Int,
                                                    id: Long ->
            Toast.makeText(parent.context, pos, Toast.LENGTH_LONG).show()
            true
        }
    }
}
