package com.example.designimplementation.custom.user_list_item

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.example.designimplementation.R
import com.example.designimplementation.databinding.ViewUserListItemBinding

class UiUserListItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding by lazy { ViewUserListItemBinding.bind(this) }

    var image: Drawable?
        get() = binding.image.drawable
        set(value) {
            binding.image.setImageDrawable(value)
        }

    var title: String
        get() = binding.title.text.toString()
        set(value) {
            binding.title.text = value
        }

    var followed: Boolean = false
        set(value) {
            field = value
            binding.buttonFollow.isVisible = !value
            binding.buttonUnfollow.isVisible = value
        }

    init {
        inflate(context, R.layout.view_user_list_item, this)

        gravity = Gravity.CENTER_VERTICAL
        orientation = HORIZONTAL

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.UiUserListItem)
        image = typedArray.getDrawable(R.styleable.UiUserListItem_user_list_item_image)
        title = typedArray.getString(R.styleable.UiUserListItem_user_list_item_title) ?: ""
        followed = typedArray.getBoolean(R.styleable.UiUserListItem_user_list_item_checked, false)
        typedArray.recycle()

        binding.buttonFollow.setOnClickListener {
            followed = true
        }
        binding.buttonUnfollow.setOnClickListener {
            followed = false
        }
    }
}