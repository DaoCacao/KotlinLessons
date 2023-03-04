package com.example.testapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.ActivityFrameBinding

/** Activity - ComponentActivity - FragmentActivity - AppCompatActivity
 *
 * Make an app that takes fibonacci number position as input and displays fibonacci number at that position.
 * Screen contains form with title, text field, button and result, [img.png]:
 * - Form should be placed in center of the screen, fill parent horizontally and wrap vertically.
 * - Form should has horizontal space from parent 16dp. and vertical space 8dp between child views.
 * - Title should be "Enter fibonacci position to calculate", fill parent horizontally, text should be aligned to start.
 * - Text field should be editable with hint "Enter position", fill parent horizontally and input should be numeric only.
 * - Button should be accent color, wrap its content and aligned to end, should contains text "Calculate"
 * - Result should be text, fill parent horizontally, text should be aligned to center
 *
 * Logic:
 * - Button should be disabled by default.
 * - Button should be enabled when text field is not empty.
 * - Button should be disabled when its clicked (it remains disabled until user updates input).
 * - Result should be not visible by default.
 * - Result should be visible when calculation is done and show the result.
 *
 * Hint:
 * - Read about view margins and paddings and whats the difference between them.
 * - Read about text field afterTextChanged listener to change button state depending on user input.
 * - Read about input type to make text field numeric only,
 * - Reuse code for fibonacci calculation from previous lessons.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFrameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textView1 = delegate.findViewById<TextView>(R.id.tv_title)
        val textView2 = binding.textSubtitle
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}