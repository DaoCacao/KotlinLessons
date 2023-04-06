package com.example.lessonapp3

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

object SignUpInterface {
    interface View{
        fun goBackToEnterActivity(){
            val intent = Intent()
            //startActivity(intent)
        }
    }
    interface Presenter{

    }
}