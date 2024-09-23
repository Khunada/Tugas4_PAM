package com.example.tugas4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.app.Activity

class MainActivity : Activity() {

    private lateinit var adapter: PersonAdapter
    private val personList = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)
        val buttonAddPerson = findViewById<Button>(R.id.buttonAddPerson)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Inisialisasi RecyclerView
        adapter = PersonAdapter(personList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Tambah data saat tombol ditekan
        buttonAddPerson.setOnClickListener {
            val name = editTextName.text.toString()
            val ageText = editTextAge.text.toString()

            // Validasi input
            if (name.isNotBlank() && ageText.isNotBlank()) {
                val age = ageText.toIntOrNull()

                if (age != null && age >= 0) {
                    val person = Person(name, age)
                    adapter.addPerson(person)

                    // Bersihkan input setelah data ditambahkan
                    editTextName.text.clear()
                    editTextAge.text.clear()
                } else {
                    Toast.makeText(this, "Umur harus angka positif", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Nama dan Umur tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
