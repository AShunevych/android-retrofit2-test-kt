package com.ashunevich.android_retrofit2_test_kt

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ashunevich.android_retrofit2_test_kt.databinding.JsonItemBinding

class JsonRecyclerViewAdapter : RecyclerView.Adapter<JsonRecyclerViewAdapter.MyViewHolder>() {

    private var padList: MutableList<ItemJSON> = mutableListOf()
    private lateinit var context: Context
    private lateinit var itemEntity: ItemJSON

    //This method inflates view present in the RecyclerView
    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding =
            JsonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(itemBinding)
    }

    //Binding the data using get() method of POJO object
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(padList[position])
        itemEntity = padList[position]
        holder.bindItems(itemEntity)
    }


    override fun getItemCount(): Int {
        return padList.size
    }


    fun getAccountAtPosition(position: Int): ItemJSON {
        return padList[position]
    }

    //View holder class, where all view components are defined
    inner class MyViewHolder(itemBinding: JsonItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        private val binding: JsonItemBinding = itemBinding
        fun bindItems(noteEntity: ItemJSON) {
            binding.dateView.text = noteEntity.title
            binding.noteView.text = noteEntity.id.toString()
        }
    }

    fun swap(notes: MutableList<ItemJSON>) {
        val diffCallback = RecyclerViewDiffUtil(padList, notes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.padList.clear()
        this.padList.addAll(notes)

        diffResult.dispatchUpdatesTo(this)
    }
}

