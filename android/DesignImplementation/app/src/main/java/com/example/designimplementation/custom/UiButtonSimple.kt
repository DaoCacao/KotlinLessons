package com.example.designimplementation.custom

import android.content.Context
import android.util.AttributeSet
import com.example.designimplementation.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.ShapeAppearanceModel

/**
 * Primary Button
 *
 * [Component](https://www.figma.com/file/bxvcccu0IIUKjFTfhq20Q4/UI-kit?type=design&node-id=1306-30273&mode=dev)
 */
/// Custom view baby
class UiButtonSimple @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : MaterialButton(context, attrs, defStyleAttr) {

    init {
        backgroundTintList = context.getColorStateList(R.color.colorAccentPrimary)
        setPadding(16.dpToPx, 12.dpToPx, 16.dpToPx, 12.dpToPx)
        insetTop = 0
        insetBottom = 0
        minWidth = 0
        minHeight = 0
        setTextAppearance(R.style.Typography_Button)
        setTextColor(context.getColorStateList(R.color.colorSurfacePrimary))
        shapeAppearanceModel = ShapeAppearanceModel.builder(context, R.style.Shape_Button, 0).build()
    }
}