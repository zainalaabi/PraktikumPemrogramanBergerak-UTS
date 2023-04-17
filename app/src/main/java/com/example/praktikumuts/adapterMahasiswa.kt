package com.example.praktikumuts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class adapterMahasiswa(private val list:ArrayList<dataMahasiswa>,private val context: Context) :
    RecyclerView.Adapter<adapterMahasiswa.mahasiswaViewHolder>()  {
    class mahasiswaViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        val namaMhs: TextView =itemview.findViewById(R.id.tvNama)
        val niMhs: TextView =itemview.findViewById(R.id.tvNim)
        val umurMhs: TextView =itemview.findViewById(R.id.tvUmur)
        val fotoMhs :ImageView =itemview.findViewById(R.id.ivFoto)
    }
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): adapterMahasiswa.mahasiswaViewHolder {
        val view :View =LayoutInflater.from(parent.context).inflate(R.layout.cardlist,parent,false)
        return mahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: adapterMahasiswa.mahasiswaViewHolder, position: Int) {
        holder.namaMhs.text = list[position].namaMhs
        holder.niMhs.text = list[position].nimMhs
        holder.umurMhs.text = list[position].umurMhs
        Glide.with(context)
            .load(list[position].fotoMhs)
            .into(holder.fotoMhs)
//        Glide.with(context).
    //        load(list[position].fotoMhs).into(holder.fotoMhs)
//        holder.fotoMhs.setImageResource(list[position].fotoMhs)

    }

    override fun getItemCount(): Int {
        return list.size
    }

}