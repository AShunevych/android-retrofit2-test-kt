package com.ashunevich.android_retrofit2_test_kt

import androidx.recyclerview.widget.DiffUtil

class RecyclerViewDiffUtil (private val oldList: MutableList<ItemJSON>,
                            private val newList: MutableList<ItemJSON>): DiffUtil.Callback() {



    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size



    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }



}