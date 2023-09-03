package com.example.roomydesign.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.roomydesign.R
import com.example.roomydesign.databinding.RoomyTextButtonBinding

class RoomyTextButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding by lazy { RoomyTextButtonBinding.bind(this) }
    var text: String
        get() = binding.button.text.toString()
        set(value) {
            binding.button.text = value
        }

    init {
        inflate(context, R.layout.roomy_text_button, this)


        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoomyTextButton)
        text = typedArray.getString(R.styleable.RoomyTextButton_txtbtn_text) ?: ""
        typedArray.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        binding.button.setOnClickListener(l)
    }
}