package com.example.shared.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object GlideBindingAdapter {
    @BindingAdapter("imageFromUrl")
    @JvmStatic
    fun bindImageFromUrl(view: ImageView, imageFromUrl: String?) {
        if (imageFromUrl != null && imageFromUrl.isNotEmpty()) {
            GlideApp.with(view.context.applicationContext)
                .load(GlideUrlNoParams(imageFromUrl))
                .into(view)
        }
    }
}