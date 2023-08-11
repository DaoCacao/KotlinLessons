package com.example.roomydesign.customViews

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import androidx.core.view.setPadding
import com.example.roomydesign.R
import com.example.roomydesign.databinding.RoomyUserListItemBinding


class RoomyUserListItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {


    private lateinit var binding: RoomyUserListItemBinding

    var icon: Drawable?
        get() = binding.icon.drawable
        set(value) {

            if (value == null) {
                binding.icon.setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.avatar))
            } else {
                binding.icon.setImageDrawable(value)
            }
        }

    var title: String
        get() = binding.userName.text.toString()
        set(value) {
            binding.userName.text = value
        }

    var followed: Boolean = false
        set(value) {
            field = value
            binding.btnFollow.isVisible = !value
            binding.btnUnfollow.isVisible = value
        }

    init {
        inflate(context, R.layout.roomy_user_list_item, this)
        binding=RoomyUserListItemBinding.bind(this)

        gravity = Gravity.CENTER_VERTICAL
        orientation = HORIZONTAL
        setPadding(16.dpToPx)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoomyUserListItem)
        icon = typedArray.getDrawable(R.styleable.RoomyUserListItem_user_list_item_icon)
        title = typedArray.getString(R.styleable.RoomyUserListItem_user_list_item_name) ?: ""
        followed =
            typedArray.getBoolean(R.styleable.RoomyUserListItem_user_list_item_checked, false)
        typedArray.recycle()

        binding.btnFollow.setOnClickListener {
            followed = true
        }
        binding.btnUnfollow.setOnClickListener {
            followed = false
        }
    }

}