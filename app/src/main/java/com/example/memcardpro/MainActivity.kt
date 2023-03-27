package com.example.memcardpro

import android.os.Bundle
import android.widget.SearchView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.memcardpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)




    }

    class MainActivity : AppCompatActivity() {

        private lateinit var searchView: SearchView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            searchView = findViewById(R.id.search_view)

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    // Perform search
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    // Update search results as the user types
                    return true
                }
            })
        }
    }

    
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu_search, menu)
//        val searchItem = menu.findItem(R.id.action_search)
//        val searchView = searchItem.actionView as SearchView
//        searchView.setOnQueryTextListener(this)
//        super.onCreateOptionsMenu(menu, inflater)
//    }

//    override fun onQueryTextSubmit(query: String): Boolean {
//        performSearch(query)
//        return true
//    }
//
//    override fun onQueryTextChange(newText: String): Boolean {
//        performSearch(newText)
//        return true
//    }
//
//    private fun performSearch(query: String) {
//        // Perform search and update search results
//    }
//
//
//    private fun performSearch(query: String) {
//        val files = getFilesMatchingQuery(query)
//        updateSearchResults(files)
//    }
//
//    private fun getFilesMatchingQuery(query: String): List<File> {
//        val rootDir = requireContext().getExternalFilesDir(null)
//        val files = rootDir?.listFiles { file ->
//            file.isFile && file.name.contains(query, true)
//        }
//        return files?.toList() ?: emptyList()
//    }
//
//    private fun updateSearchResults(files: List<File>) {
//        val adapter = recyclerView.adapter as FileListAdapter
//        adapter.submitList(files)
//    }

}