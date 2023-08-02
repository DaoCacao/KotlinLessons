package com.example.designimplementation.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.designimplementation.R
import com.example.designimplementation.databinding.ViewFilledButtonBinding

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

    private val binding by lazy { ViewFilledButtonBinding.bind(this) }

    init {
        inflate(context, R.layout.view_filled_button, this)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        binding.button.setOnClickListener(l)
    }
}