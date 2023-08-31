package com.example.roomydesign.customViews

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.widget.Toolbar
import androidx.core.view.setPadding
import com.example.roomydesign.R


class RoomyAppBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?=null,
    defStyleAttr: Int=0,
    setBackButton: Boolean

): Toolbar(context, attrs, defStyleAttr) {


    init {
        setPadding(16.toPx)
        setBackgroundColor(context.getColor(R.color.accent_primary))
        setTitleTextAppearance(context, R.style.RoomyText_AppBarText)
        textAlignment= TEXT_ALIGNMENT_CENTER

        if(setBackButton){
            setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
        }
    }
}