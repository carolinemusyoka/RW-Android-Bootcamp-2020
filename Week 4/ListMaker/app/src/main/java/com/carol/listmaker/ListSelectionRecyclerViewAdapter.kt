package com.carol.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListSelectionRecyclerViewAdapter: RecyclerView.Adapter<ListSelectionViewHolder>() {
    val listTitles = arrayOf("Shopping List", "Chores", "Android","Tutorials")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
         val view = LayoutInflater.from(parent.context)
             .inflate(R.layout.list_selection_view_holder,parent,false)
        return ListSelectionViewHolder()
    }

    override fun getItemCount(): Int {
        return listTitles.size

    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}