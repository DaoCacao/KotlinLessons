package com.example.designimplementation.compose.component

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designimplementation.R
import com.example.designimplementation.compose.theme.DesignImplementationTheme
import com.google.accompanist.drawablepainter.rememberDrawablePainter

class UiAvatarFieldView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AbstractComposeView(context, attrs, defStyleAttr) {

    var image: Drawable? = null
    @DrawableRes var icon: Int? = null
    var letter: String = ""
    var actionPrimary: String = ""
    var actionSecondary: String = ""
    var onActionPrimaryClick: () -> Unit = {}
    var onActionSecondaryClick: () -> Unit = {}


    @Composable
    override fun Content() {
        DesignImplementationTheme {
            UiAvatarField(
                image = image?.let { rememberDrawablePainter(it) },
                icon = icon?.let { painterResource(it) } ?: painterResource(R.drawable.ic_launcher_foreground),
                letter = letter,
                actionPrimary = actionPrimary,
                actionSecondary = actionSecondary,
                onActionPrimaryClick = onActionPrimaryClick,
                onActionSecondaryClick = onActionSecondaryClick,
            )
        }
    }
}

@Composable
fun UiAvatarField(
    modifier: Modifier = Modifier,
    image: Painter? = painterResource(R.drawable.ic_launcher_foreground),
    icon: Painter,
    letter: String,
    actionPrimary: String,
    actionSecondary: String,
    onActionPrimaryClick: () -> Unit,
    onActionSecondaryClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        if (image != null)
            Image(
                modifier = Modifier.size(80.dp),
                painter = image,
                contentDescription = null,
            )
        else {
            Image(
                modifier = Modifier.size(80.dp),
                painter = icon,
                contentDescription = null,
            )
        }
        Column(

        ) {
            UiTextButton(
                text = actionPrimary,
                onClick = onActionPrimaryClick,
            )
            UiTextButton(
                text = actionSecondary,
                onClick = onActionSecondaryClick,
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun UiTextButton(
    text: String,
    onClick: () -> Unit,
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color.Transparent,
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp),
        ) {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    DesignImplementationTheme {
        UiAvatarField(
            image = painterResource(R.drawable.ic_launcher_foreground),
            icon = painterResource(R.drawable.ic_launcher_foreground),
            letter = "A",
            actionPrimary = "Primary button",
            actionSecondary = "Secondary button",
            onActionPrimaryClick = { /*TODO*/ },
            onActionSecondaryClick = { /*TODO*/ },
        )
    }
}