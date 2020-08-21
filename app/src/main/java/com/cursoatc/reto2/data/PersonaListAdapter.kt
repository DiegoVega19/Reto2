package com.cursoatc.reto2.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cursoatc.reto2.R
import com.cursoatc.reto2.model.Persona

class PersonaListAdapter(val list:ArrayList<Persona>, private  val context: Context):RecyclerView.Adapter<PersonaListAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaListAdapter.MyViewHolder {

        val view= LayoutInflater.from(context).inflate(R.layout.designcard,parent,false)
        return  MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: PersonaListAdapter.MyViewHolder, position: Int) {
        holder.bindItem(list[position])
    }
   inner class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(persona: Persona){
            var nombre:TextView=itemView.findViewById(R.id.nameid) as TextView
            var apellido:TextView=itemView.findViewById(R.id.lastid) as TextView
            var edad:TextView=itemView.findViewById(R.id.yearsid) as TextView
            var profesion:TextView=itemView.findViewById(R.id.universityid) as TextView
            var image:ImageView=itemView.findViewById(R.id.imageid) as ImageView
            nombre.text=persona.Nombre
            apellido.text=persona.Apellido
            edad.text= ("${persona.Edad} Años")
            profesion.text=persona.Escolaridad
         image.setImageResource(persona.foto!!)


        }
    }
}