package com.example.roomydesign.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.roomydesign.R
import com.example.roomydesign.databinding.ButtonOutlinedBinding

import com.google.android.material.button.MaterialButton


class RoomyOutlinedButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding by lazy { ButtonOutlinedBinding.bind(this) }

    var text: String
        get() = binding.button.text.toString()
        set(value) {
            binding.button.text = value
        }

    init {
        inflate(context, R.layout.button_outlined, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoomyOutlinedButton)
        text = typedArray.getString(R.styleable.RoomyOutlinedButton_olbtn_text) ?: ""
        typedArray.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        binding.button.setOnClickListener(l)
    }
}


