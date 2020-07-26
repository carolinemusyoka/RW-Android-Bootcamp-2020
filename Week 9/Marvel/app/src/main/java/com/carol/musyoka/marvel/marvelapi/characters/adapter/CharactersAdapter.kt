package com.carol.musyoka.marvel.marvelapi.characters.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carol.musyoka.marvel.R
import com.carol.musyoka.marvel.marvelapi.imageloader.PicassoLoader
import kotlinx.android.synthetic.main.item_characters.view.*
import com.carol.musyoka.marvel.marvelapi.characters.model.Result

class CharactersAdapter(private val items: List<Result>,
                        private val picassoLoader: PicassoLoader,
                        private val context: Context) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_characters, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = items[position]
        holder.marvelCharacterName.text = character.name
        holder.marvelDescription.text = context.getString(R.string.characters_fragment_description)
        picassoLoader.loadDetailImageIntoImageView(
            imageview = holder.marvelImage,
            thumbnail = character.thumbnail
        )
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val marvelCharacterName = view.marvel_character_title
        val marvelDescription = view.marvel_character_description
        val marvelImage = view.marvel_character_image
    }
}