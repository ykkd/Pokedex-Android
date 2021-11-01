package com.example.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.common.R
import com.example.common.databinding.LayoutRetryViewBinding
import com.example.model.UiState

// url: https://qiita.com/kwhrstr1206/items/93827190a535b11bd064
class RetryView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: LayoutRetryViewBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.layout_retry_view,
        this,
        true
    )

    fun setState(uiState: UiState) {
        binding.uiState = uiState
    }

    fun setOnClickRetryListener(
        onClick: () -> Unit
    ) {
        binding.onClickRetryBtn = OnClickListener {
            onClick.invoke()
        }
    }
}

object RetryViewBindings {

    @BindingAdapter("uiState")
    @JvmStatic
    fun RetryView.setState(uiState: UiState?) {
        uiState?.let {
            this.setState(uiState)
        }
    }

    @BindingAdapter("onClickRetryBtn")
    @JvmStatic
    fun RetryView.setOnClickRetryBtn(
        onClick: (() -> Unit)?
    ) {
        onClick?.let {
            this.setOnClickRetryListener(it)
        }
    }
}