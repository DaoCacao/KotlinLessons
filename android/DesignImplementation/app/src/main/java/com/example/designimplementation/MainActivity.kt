package com.example.designimplementation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.designimplementation.compose.theme.DesignImplementationTheme
import com.example.designimplementation.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.avatarFieldView.let {
            it.image = ContextCompat.getDrawable(this, R.drawable.backgound_button)
            it.icon = R.drawable.ic_launcher_foreground
            it.letter = "B"
            it.actionPrimary = "Primary"
            it.actionSecondary = "Secondary"
            it.onActionPrimaryClick = { println("Primary Clicked") }
            it.onActionSecondaryClick = { println("Secondary Clicked") }
        }

//        setContent {
//            DesignImplementationTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background,
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesignImplementationTheme {
        Greeting("Android")
    }
}