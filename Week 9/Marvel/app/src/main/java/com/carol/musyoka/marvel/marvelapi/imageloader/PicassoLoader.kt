package com.carol.musyoka.marvel.marvelapi.imageloader

import android.widget.ImageView
import com.carol.musyoka.marvel.R
import com.carol.musyoka.marvel.marvelapi.characters.model.Thumbnail
import com.squareup.picasso.Picasso
import javax.inject.Inject

class PicassoLoader @Inject constructor() {

    fun loadDetailImageIntoImageView(imageview: ImageView, thumbnail: Thumbnail) {
        Picasso.get()
            .load(thumbnailDetailBuildUrl(thumbnail))
            .centerCrop()
            .resize(DETAIL_SIZE, DETAIL_SIZE)
            .error(R.drawable.ic_avengers)
            .into(imageview)

        println("engineerKunle --- url ${thumbnailDetailBuildUrl(thumbnail)}")
    }

    private fun thumbnailDetailBuildUrl(thumbnail: Thumbnail): String {
        return thumbnail.path + DETAIL_IMAGE + thumbnail.extension
    }

    companion object {
        private const val DETAIL_IMAGE = "/detail."
        private const val DETAIL_SIZE  = 400
    }
}