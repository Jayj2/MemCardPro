package com.example.memcardpro


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.memcardpro.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.action_search)
        recyclerView = findViewById(R.id.recycler_view)

        val searchHistoryHelper = SearchHistoryHelper(this)
        val searchHistoryAdapter = SearchHistoryAdapter(searchHistoryHelper.getSearchHistory())
        // Initialize the SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrBlank()) {
                    searchHistoryHelper.saveSearchQuery(query)
                    searchHistoryAdapter.updateSearchHistory(searchHistoryHelper.getSearchHistory())
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

    }
}

