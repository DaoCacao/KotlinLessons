package com.example.roomydesign.customViews

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.provider.MediaStore
import android.util.AttributeSet
import android.view.Gravity
import android.widget.Gallery
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.setPadding
import com.example.roomydesign.R
import com.example.roomydesign.databinding.RoomyAddPhotoItemBinding


class RoomyAddPhotoItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {


    private  val binding by lazy { RoomyAddPhotoItemBinding.bind(this) }

    var icon: Drawable?
        get() = binding.icon.drawable
        set(value) {

            if (value == null) {
                binding.icon.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.avatar
                    )
                )
            } else {
                binding.icon.setImageDrawable(value)
            }
        }

    init {
        inflate(context, R.layout.roomy_add_photo_item, this)


        gravity = Gravity.CENTER_VERTICAL
        orientation = HORIZONTAL
        setPadding(16.dpToPx)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoomyAddPhotoItem)
        icon = typedArray.getDrawable(R.styleable.RoomyAddPhotoItem_add_photo_icon)
        typedArray.recycle()

        binding.fromGallery.setOnClickListener {

        }
        binding.takePhoto.setOnClickListener {

        }
    }


}