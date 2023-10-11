package com.example.memcardpro

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.memcardpro.databinding.ActivityMainBinding
import android.view.View
import android.widget.*
import com.example.memcardpro.R.id.cardContainer



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var searchView: SearchView
    private lateinit var searchHistoryHelper: SearchHistoryHelper


    private lateinit var searchHistoryDialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchHistoryHelper = SearchHistoryHelper(this)

        searchHistoryHelper.initialize(this)

        val searchHistoryListView = ListView(this)
        val searchHistoryAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            searchHistoryHelper.getSearchHistory().toList()
        )
        searchHistoryListView.adapter = searchHistoryAdapter
        searchHistoryListView.setOnItemClickListener { _, _, position, _ ->
            val query = searchHistoryAdapter.getItem(position)
            searchView.setQuery(query, true)
            searchHistoryDialog.dismiss()
        }

        searchHistoryDialog = AlertDialog.Builder(this)
            .setTitle("Search History")
            .setView(searchHistoryListView)
            .setPositiveButton("Clear") { _, _ ->
                searchHistoryHelper.clearSearchHistory()
                searchHistoryAdapter.clear()
            }
            .setNegativeButton("Close") { dialog, _ ->
                dialog.dismiss()
            }
            .create()

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



        val addButton = findViewById<Button>(R.id.button)
        val cardView = LayoutInflater.from(this).inflate(R.layout.dialog_create_card, null)


        addButton.setOnClickListener {
            // Inflate the dialog layout
            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_create_card, null)

            // Create an AlertDialog
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setView(dialogView)
            val dialog = dialogBuilder.create()

            // Find views in the dialog layout
            val cardNameEditText = dialogView.findViewById<EditText>(R.id.cardNameEditText)
            val okButton = dialogView.findViewById<Button>(R.id.okButton)
            val cancelButton = dialogView.findViewById<Button>(R.id.cancelButton)

            // Set click listener for the "OK" button
            okButton.setOnClickListener {
                val cardName = cardNameEditText.text.toString()
                // Create the virtual card with the given name and add it to the container

                val cardContainer = findViewById<LinearLayout>(R.id.cardContainer).apply {
                    addView(cardView)
                }
                dialog.dismiss()
            }

            // Set click listener for the "Cancel" button
            cancelButton.setOnClickListener {
                dialog.dismiss()
            }

            // Show the dialog
            dialog.show()
        }







    }

    private val virtualCardList = mutableListOf<VirtualCard>()
    val cardNameEditText: EditText = findViewById<EditText>(R.id.cardNameEditText)




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

    class SearchHistoryHelper(mainActivity: com.example.memcardpro.MainActivity) {
        private lateinit var sharedPrefs: SharedPreferences
        private lateinit var editor: SharedPreferences.Editor

        fun initialize(context: Context) {
            sharedPrefs = context.getSharedPreferences("SearchHistory", Context.MODE_PRIVATE)
            editor = sharedPrefs.edit()
        }

        fun saveSearchQuery(query: String) {
            val historySet = getSearchHistory().toMutableSet()
            historySet.add(query)
            editor.putStringSet("search_history", historySet)
            editor.apply()
        }

        fun getSearchHistory(): Set<String> {
            return sharedPrefs.getStringSet("search_history", HashSet()) ?: HashSet()
        }

        fun clearSearchHistory() {
            editor.clear()
            editor.apply()
        }
    }

    data class VirtualCard(val name: String) {
        // You can add more properties here if needed
    }

}

private fun LinearLayout.addView(cardView: Unit) {

}


private fun Number.addView(cardView: View?) {


}







