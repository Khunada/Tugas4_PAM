package com.example.tugas4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(private val personList: MutableList<Person>) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.textViewName)
        val textViewAge: TextView = view.findViewById(R.id.textViewAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = personList[position]
        holder.textViewName.text = person.name
        holder.textViewAge.text = "Umur: ${person.age}"
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    fun addPerson(person: Person) {
        personList.add(person)
        notifyItemInserted(personList.size - 1)
    }
}
