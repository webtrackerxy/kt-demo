package com.taskapp.moviecharacter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.widget.*
import com.taskapp.moviecharacter.models.CharacterObject
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {

  private lateinit var txtName: TextView
  private lateinit var txtNickName: TextView
  private lateinit var txtOccupation: TextView
  private lateinit var txtSeasonAppearance: TextView
  private lateinit var txtStatus: TextView
  private lateinit var imageView: ImageView

  companion object {

    const val EXTRA_IMAGE = "image"
    const val EXTRA_NAME = "name"
    const val EXTRA_OCCUPATION = "occupation"
    const val EXTRA_SEASON_APPERANCE = "seasonApperance"
    const val EXTRA_STATUS = "status"
    const val EXTRA_NICKNAME = "nickname"


    fun newIntent(context: Context, recipe: CharacterObject): Intent {
      val detailIntent = Intent(context, DetailActivity::class.java)

      detailIntent.putExtra(EXTRA_IMAGE, recipe.img)
      detailIntent.putExtra(EXTRA_NAME, recipe.name)
      detailIntent.putExtra(EXTRA_OCCUPATION, recipe.occupation.toString())
      detailIntent.putExtra(EXTRA_SEASON_APPERANCE, recipe.appearance.toString())

      detailIntent.putExtra(EXTRA_STATUS, recipe.status)
      detailIntent.putExtra(EXTRA_NICKNAME, recipe.nickname)

      return detailIntent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recipe_detail)

    /*
   -	Image
   -	Name
   -	Occupation
   -	Status
   -	Nickname
   -	Season appearance
   */
    val image = intent.extras.getString(EXTRA_IMAGE)
    val name = intent.extras.getString(EXTRA_NAME)
    val occupation = "Occupation: " + intent.extras.getString(EXTRA_OCCUPATION)
    val status = "Status: " + intent.extras.getString(EXTRA_STATUS)
    val nickname = "Nick Name: " +  intent.extras.getString(EXTRA_NICKNAME)
    val seasonAppearance = "Season Appearance: " + intent.extras.getString(EXTRA_SEASON_APPERANCE)

    setTitle(name)

    imageView = findViewById<ImageView>(R.id.character_image)
    Picasso.with(this@DetailActivity).load(image).placeholder(R.mipmap.ic_launcher).into(imageView)

    txtName = findViewById<TextView>(R.id.character_name)
    txtOccupation = findViewById<TextView>(R.id.character_occupation)
    txtStatus = findViewById<TextView>(R.id.character_status)
    txtNickName = findViewById<TextView>(R.id.character_nickname)
    txtSeasonAppearance = findViewById<TextView>(R.id.character_season_appearance)


    txtName.text = ""
    txtOccupation.text =  occupation
    txtStatus.text = status
    txtNickName.text = nickname
    txtSeasonAppearance.text = seasonAppearance

    val titleTypeFace = ResourcesCompat.getFont(this, R.font.josefinsans_bold)
    txtName.typeface = titleTypeFace
    txtOccupation.typeface = titleTypeFace

    txtNickName.typeface = titleTypeFace
    txtSeasonAppearance.typeface = titleTypeFace

    val subtitleTypeFace = ResourcesCompat.getFont(this, R.font.josefinsans_semibolditalic)
    txtStatus.typeface = subtitleTypeFace
  }
}
