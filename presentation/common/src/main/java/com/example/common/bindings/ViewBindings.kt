package com.example.common.bindings

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBindings {

    @BindingAdapter("visibleGone")
    @JvmStatic
    fun View.showHide(show: Boolean?) {
        show?: return
        this.visibility = if (show == true) View.VISIBLE else View.GONE
    }
}