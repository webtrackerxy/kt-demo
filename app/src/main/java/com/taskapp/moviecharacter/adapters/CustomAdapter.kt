package com.taskapp.moviecharacter.adapters

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.taskapp.moviecharacter.models.CharacterObject
import com.taskapp.moviecharacter.R
import com.squareup.picasso.Picasso

class CustomAdapter(private val context: Context,
                    private val dataSource: MutableList<CharacterObject>) : BaseAdapter() {

  private val inflater: LayoutInflater
      = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

  companion object {
    private val LABEL_COLORS = hashMapOf(
        "Low-Carb" to R.color.colorLowCarb,
        "Low-Fat" to R.color.colorLowFat,
        "Low-Sodium" to R.color.colorLowSodium,
        "Medium-Carb" to R.color.colorMediumCarb,
        "Vegetarian" to R.color.colorVegetarian,
        "Balanced" to R.color.colorBalanced
    )
  }

  override fun getCount(): Int {
    return dataSource.size
  }

  override fun getItem(position: Int): Any {
    return dataSource[position]
  }

  override fun getItemId(position: Int): Long {
    return position.toLong()
  }

  override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
    val view: View
    val holder: ViewHolder

    if (convertView == null) {

      view = inflater.inflate(R.layout.list_item_recipe, parent, false)

      holder = ViewHolder()
      holder.thumbnailImageView = view.findViewById(R.id.recipe_list_thumbnail) as ImageView
      holder.titleTextView = view.findViewById(R.id.recipe_list_title) as TextView
      holder.subtitleTextView = view.findViewById(R.id.recipe_list_subtitle) as TextView
      holder.detailTextView = view.findViewById(R.id.recipe_list_detail) as TextView

      view.tag = holder
    } else {

      view = convertView
      holder = convertView.tag as ViewHolder
    }

    val titleTextView = holder.titleTextView
    val subtitleTextView = holder.subtitleTextView
    val detailTextView = holder.detailTextView
    val thumbnailImageView = holder.thumbnailImageView

    val character = getItem(position) as CharacterObject

    titleTextView.text = character.name
    subtitleTextView.text = character.nickname
    detailTextView.text = character.status

    Picasso.with(context).load(character.img).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)

    val titleTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_bold)
    titleTextView.typeface = titleTypeFace

    val subtitleTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_semibolditalic)
    subtitleTextView.typeface = subtitleTypeFace

    val detailTypeFace = ResourcesCompat.getFont(context, R.font.quicksand_bold)
    detailTextView.typeface = detailTypeFace

    detailTextView.setTextColor(
        ContextCompat.getColor(context, LABEL_COLORS[character.category] ?: R.color.colorPrimary))

    return view
  }

  private class ViewHolder {
    lateinit var titleTextView: TextView
    lateinit var subtitleTextView: TextView
    lateinit var detailTextView: TextView
    lateinit var thumbnailImageView: ImageView
  }
}
