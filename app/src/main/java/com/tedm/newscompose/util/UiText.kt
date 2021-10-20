package com.tedm.newscompose.util

import androidx.annotation.StringRes
import com.tedm.newscompose.R

sealed class UiText {
    data class DynamicString(val value: String) : UiText()
    data class StringResource(@StringRes val id: Int) : UiText()

    companion object {
        fun unknownError(): UiText {
            return StringResource(R.string.error_unknown)
        }

        fun cityHasBeenLoaded(): UiText {
            return StringResource(R.string.city_loaded)
        }
    }
}
