package com.example.roomydesign.customViews

import android.content.res.Resources


val Int.dpToPx: Int get() = (this / Resources.getSystem().displayMetrics.density.toInt())

val Int.toPx: Int get() = (this * Resources.getSystem().displayMetrics.density.toInt())
