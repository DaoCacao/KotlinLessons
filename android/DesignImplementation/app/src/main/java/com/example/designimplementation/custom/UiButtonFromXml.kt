package com.example.designimplementation.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.designimplementation.R

/**
 * Primary Button
 *
 * [Component](https://www.figma.com/file/bxvcccu0IIUKjFTfhq20Q4/UI-kit?type=design&node-id=1306-30273&mode=dev)
 */
/// Custom view baby
class UiButtonFromXml @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_button, this)
    }
}