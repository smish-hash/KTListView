package com.example.ktlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var m_city: String = ""
    val cities = ArrayList<String>()
    lateinit var listAdapter: ArrayAdapter<String>
    lateinit var addItemDialog: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val cities = ArrayList<String>("Boston", "Mumbai", "Chennai", "Bhubaneswar", "Cuttack", "Kolkata", "Pune")
        initData()

        val list = findViewById<ListView>(R.id.listView)
        listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)
        list.adapter = listAdapter

        addItemDialog = AlertDialog.Builder(this)
        addItemDialog.create()
        addItemDialog.setTitle("Add City")
        addItemDialog.setView(R.layout.dialoglayout)
        val editText: EditText? = findViewById<EditText>(R.id.itemInput)
        addItemDialog.setPositiveButton("Ok") { _, _ ->
            m_city = editText?.text.toString()
        }
        addItemDialog.setNegativeButton("Cancel") { _, _ ->
            Toast.makeText(this, "City not added", Toast.LENGTH_SHORT).show()
        }


    }

    private fun initData() {
        cities.add("Delhi")
        cities.add("Mumbai")
        cities.add("Chennai")
        cities.add("Bhubaneswar")
        cities.add("Pune")
        cities.add("Bangalore")
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add -> {
                addItemDialog.show()
                addItem()
            }
        }

        return true
    }

    private fun addItem() {
        cities.add("m_city")
        listAdapter.notifyDataSetChanged()
    }
}