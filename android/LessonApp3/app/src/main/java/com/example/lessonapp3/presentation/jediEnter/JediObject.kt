package com.example.lessonapp3.presentation.jediEnter

object JediObject {
    interface View {

        fun navigateToEnterActivity()
        fun navigateToMainActivity(JediID: Int)
        fun showWrongName()
        fun userAlreadyExist()
        fun invalidPassword()
        fun disableErrors()
    }

    interface Presenter {
        fun jediNameInput(name: String)
        fun signInAsJedi()
        fun jediPasswordInput(password: String)
        fun dispose()
        fun getAllJedi()
    }
}