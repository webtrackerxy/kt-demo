package com.taskapp.moviecharacter.networking

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.ListView
import com.taskapp.moviecharacter.models.CharacterObject
import com.google.gson.GsonBuilder
import com.taskapp.moviecharacter.DetailActivity
import com.taskapp.moviecharacter.adapters.CustomAdapter
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader

class GetJsonWithOkHttpClient(input: Array<String>, context: Context, listView: ListView) : AsyncTask<Unit, Unit, String>() {

    var inputTextValue = input[0]
    var seasionTextValue = input[1]
    val mContext = context
    val mListView = listView
    override fun doInBackground(vararg params: Unit?): String? {
        val networkClient = NetworkClient()
        val stream = BufferedInputStream(
                networkClient.get("https://breakingbadapi.com/api/characters"))

        return readStream(stream)
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        val gson = GsonBuilder().create()
        val characters= gson.fromJson(result,Array<CharacterObject>::class.java).toList()
        val listdata = emptyArray<CharacterObject>().toMutableList()
        for (character in characters) {
            if (seasionTextValue !="" && seasionTextValue !="all"){

                for ( this_appearance in character.appearance ){
                    if (this_appearance == seasionTextValue.toInt()){
                        Log.d("GetJsonWithOkHttpClient", this_appearance.toString())
                        listdata.add(character)
                    }
                }

            }else {
                if (character.name == "" || character.name.contains(inputTextValue, ignoreCase = true)) {
                    Log.d("GetJsonWithOkHttpClient", character.toString())
                    listdata.add(character)
                }
            }
        }

        val adapter = CustomAdapter(dataSource = listdata, context = mContext )
        mListView.adapter = adapter

        mListView.setOnItemClickListener { _, _, position, _ ->
            val selectedRecipe = listdata[position]
            val detailIntent = DetailActivity.newIntent(mContext, selectedRecipe)
            mContext.startActivity(detailIntent)

        }
    }

    private fun readStream(inputStream: BufferedInputStream): String {
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        bufferedReader.forEachLine { stringBuilder.append(it) }
        return stringBuilder.toString()
    }
}