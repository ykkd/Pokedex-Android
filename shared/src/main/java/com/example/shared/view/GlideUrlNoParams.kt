package com.example.shared.view

import com.bumptech.glide.load.model.GlideUrl

class GlideUrlNoParams(url: String) : GlideUrl(url) {

    override fun getCacheKey(): String {
        val url = toStringUrl()
        val index = url.indexOf("?")
        return if (index > -1) {
            url.substring(0, index)
        } else {
            url
        }
    }

}