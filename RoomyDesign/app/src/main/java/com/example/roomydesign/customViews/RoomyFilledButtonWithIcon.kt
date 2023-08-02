package com.example.roomydesign.customViews

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import com.example.roomydesign.R
import com.google.android.material.button.MaterialButton

class RoomyFilledButtonWithIcon @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    icon: Resources

) : MaterialButton(context, attrs) {

    init {

        setPadding(16.dpToPx, 12.dpToPx, 16.dpToPx, 12.dpToPx)
        insetBottom = 0
        insetTop = 0
        setTextAppearance(R.style.RoomyText_FilledButton)
        textAlignment = TEXT_ALIGNMENT_CENTER
        setTextAppearance(R.style.RoomyText_FilledButton)
        cornerRadius = 24
        iconGravity= ICON_GRAVITY_END


    }
}