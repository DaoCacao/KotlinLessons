package com.example.designimplementation.custom

import android.content.res.Resources

val Int.dpToPx: Int get() = this.toFloat().dpToPx
val Float.dpToPx: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()
val Float.pxToDp: Float get() = (this / Resources.getSystem().displayMetrics.density)