package com.example.memcardpro
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



    class SearchHistoryAdapter(private var searchHistory: Set<String>) :
        RecyclerView.Adapter<SearchHistoryAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val itemTextView: TextView = view.findViewById(androidx.preference.R.id.recycler_view)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_recycler_view, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.itemTextView.text = searchHistory.elementAt(position)
        }

        override fun getItemCount(): Int {
            return searchHistory.size
        }

        fun updateSearchHistory(history: Set<String>) {
            searchHistory = history
            notifyDataSetChanged()
        }
    }
