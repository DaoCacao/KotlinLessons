package com.example.designimplementation.custom.button

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.designimplementation.R
import com.example.designimplementation.databinding.ViewOutlinedButtonBinding

/**
 * Primary Button
 *
 * [Component](https://www.figma.com/file/bxvcccu0IIUKjFTfhq20Q4/UI-kit?type=design&node-id=1306-30273&mode=dev)
 */
/// Custom view baby
class UiOutlinedButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding by lazy { ViewOutlinedButtonBinding.bind(this) }

    var text: String
        get() = binding.button.text.toString()
        set(value) {
            binding.button.text = value
        }

    init {
        inflate(context, R.layout.view_outlined_button, this)

//        context.obtainStyledAttributes(
//            attrs,
//            R.styleable.UiOutlinedButton,
//        ).use {
//            text = it.getString(R.styleable.UiOutlinedButton_button_text) ?: ""
//        }

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.UiOutlinedButton)
        text = typedArray.getString(R.styleable.UiOutlinedButton_button_text) ?: ""
        typedArray.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        binding.button.setOnClickListener(l)
    }
}