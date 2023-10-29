package com.example.memcardpro

import android.content.Context
import android.content.SharedPreferences

class SearchHistoryHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("SearchHistory", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun saveSearchQuery(query: String) {
        val historySet = getSearchHistory().toMutableSet()
        historySet.add(query)
        editor.putStringSet("search_history", historySet)
        editor.apply()
    }

    fun getSearchHistory(): Set<String> {
        return sharedPreferences.getStringSet("search_history", emptySet()) ?: emptySet()
    }
 }
