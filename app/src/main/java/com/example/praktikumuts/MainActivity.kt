package com.example.praktikumuts

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.gridLayout -> {
                gridLayout()
                return true
            }
            R.id.listLayout -> {
                listLayout()
                return true
            }

        }
        listLayout()
        return super.onOptionsItemSelected(item)
    }

    private fun listLayout() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvMhs)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = adapterMahasiswa(List, this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }

    private fun gridLayout() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvMhs)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        val adapter = adapterMahasiswa(List, this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }

    private val List = ArrayList<dataMahasiswa>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listLayout()
        List.addAll(getMhs())



    }

    private fun getMhs(): ArrayList<dataMahasiswa> {
        val dataNamaMhs = resources.getStringArray(R.array.listNama)
        val dataNimMhs = resources.getStringArray(R.array.lisNim)
        val dataUmurMhs = resources.getStringArray(R.array.listUmur)
        val dataFoto = resources.obtainTypedArray(R.array.listFoto)
        val listdata = ArrayList<dataMahasiswa>()
        for (i in dataNamaMhs.indices){
            val data = dataMahasiswa(dataNamaMhs[i],dataNimMhs[i],dataUmurMhs[i],dataFoto.getResourceId(i,-1))
            listdata.add(data)
        }
        return listdata
    }

}