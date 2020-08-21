package com.cursoatc.reto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursoatc.reto2.data.PersonaListAdapter
import com.cursoatc.reto2.model.Persona
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var adapter:PersonaListAdapter?=null
    private var personaList:ArrayList<Persona>?=null
    private var layoutManager:RecyclerView.LayoutManager?=null
    private var displayList:ArrayList<Persona>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personaList=ArrayList<Persona>()
        displayList=ArrayList<Persona>()
        layoutManager=LinearLayoutManager(this)
        adapter= PersonaListAdapter(displayList!!,this)

        myReciclerView.layoutManager=layoutManager
        myReciclerView.adapter=adapter

        var personaNameList:Array<String> = arrayOf("Diego Francisco", "Mario Jose", "Maria Francisca","Ruth Carolina","Andres Javier")
        var personaApellidoList:Array<String> = arrayOf("Davila Vega", "Perez Padro", "Davila Vega", "Martinez Enriquez", "Garcia Vega")
        var personaEdadList:Array<Int> = arrayOf(20,21,22,23,25)
        var personaEscolaridadList:Array<String> = arrayOf("Universitario","Universitario","Bachiller","Profesional","Universitario")
        var PersonaImagenList:Array<Int> = arrayOf(R.drawable.estudiante,R.drawable.estudiante,R.drawable.chica,R.drawable.chica,R.drawable.estudiante)

        for (i in 0..personaApellidoList.size-1)
        {
            var persona = Persona()
            persona.Nombre=personaNameList[i]
            persona.Apellido=personaApellidoList[i]
            persona.Edad=personaEdadList[i]
            persona.Escolaridad=personaEscolaridadList[i]
            persona.foto=PersonaImagenList[i]
            personaList?.add(persona)
            displayList!!.addAll(personaList!!)
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu,menu)
        val searchitem = menu?.findItem(R.id.SearchID)
        if (searchitem!=null)
        {
            val searchView = searchitem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty())
                    {
                        displayList?.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        personaList?.forEach {
                            if (it.Nombre?.toLowerCase(Locale.getDefault())?.contains(search)!!) {
                                displayList?.add(it)
                            }


                        }
                        adapter!!.notifyDataSetChanged()
                    }

                    else
                    {displayList?.clear()
                        displayList?.addAll(personaList!!)
                        adapter!!.notifyDataSetChanged()

                    }
                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId)
        {
            R.id.item1->{
                Toast.makeText(this,"ITEM 1", Toast.LENGTH_LONG).show()
                var i = Intent(this,SecondActivity::class.java)
                startActivity(i)
                return  super.onOptionsItemSelected(item)
            }

            else -> return super.onOptionsItemSelected(item)

        }
    }

    }

