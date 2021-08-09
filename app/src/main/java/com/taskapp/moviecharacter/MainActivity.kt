package com.taskapp.moviecharacter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.taskapp.moviecharacter.models.CharacterObject
import com.taskapp.moviecharacter.adapters.CustomAdapter
import com.taskapp.moviecharacter.networking.GetJsonWithOkHttpClient


class MainActivity : AppCompatActivity() {

  private lateinit var listView: ListView
  private lateinit var txtTitle: EditText
  private lateinit var btnSearch: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    listView = findViewById<ListView>(R.id.recipe_list_view)
    txtTitle = findViewById<EditText>(R.id.txtTitle)
    btnSearch = findViewById<Button>(R.id.btnSearch)

    btnSearch.setOnClickListener {

      val recipeList = emptyArray<CharacterObject>().toMutableList()
      val adapter = CustomAdapter(this, recipeList)
      listView.adapter = adapter

      val context = this
      val input =  Array(2){""}
      input[0] = txtTitle.text.toString()
      input[1] = ""
      GetJsonWithOkHttpClient(input, context , listView).execute()
    }

  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    val inflater: MenuInflater = menuInflater
    inflater.inflate(R.menu.my_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle item selection

    val input =  Array(2){""}
    input[0] = ""

    return when (item.itemId) {

      R.id.seasion_all -> {
        input[1] = "all"
        GetJsonWithOkHttpClient(input, this , listView).execute()
        true
      }
      R.id.seasion_1 -> {
        input[1] = "1"
        GetJsonWithOkHttpClient(input, this , listView).execute()
        true
      }
      R.id.seasion_2 -> {
        input[1] = "2"
        GetJsonWithOkHttpClient(input, this , listView).execute()
        true
      }
      R.id.seasion_3 -> {
        input[1] = "3"
        GetJsonWithOkHttpClient(input, this , listView).execute()
        true
      }
      R.id.seasion_4 -> {
        input[1] = "4"
        GetJsonWithOkHttpClient(input, this , listView).execute()
        true
      }
      R.id.seasion_5 -> {
        GetJsonWithOkHttpClient(input, this , listView).execute()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }
}
