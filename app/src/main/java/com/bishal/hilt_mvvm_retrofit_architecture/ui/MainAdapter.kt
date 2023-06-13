package com.bishal.hilt_mvvm_retrofit_architecture.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bishal.hilt_mvvm_retrofit_architecture.databinding.ItemLayoutBinding
import com.bishal.hilt_mvvm_retrofit_architecture.network.API_URL
import com.bishal.hilt_mvvm_retrofit_architecture.ui.module.Flower
import loadImage

internal class MainAdapter(private var flowers: ArrayList<Flower>) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: ItemLayoutBinding) : RecyclerView.ViewHolder(view.root) {
        val dataBinding=view
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view= ItemLayoutBinding.inflate(layoutInflater)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        with(holder.dataBinding){
            textViewUserName.text = flowers[position].name
            textViewUserEmail.text = flowers[position].category
            imageViewAvatar.loadImage("${API_URL.PHOTOS}${flowers[position].photo}")


        }


    }
    override fun getItemCount(): Int {
        return flowers.size
    }
    fun addData(list: List<Flower>) {
        flowers.addAll(list)
    }

}
