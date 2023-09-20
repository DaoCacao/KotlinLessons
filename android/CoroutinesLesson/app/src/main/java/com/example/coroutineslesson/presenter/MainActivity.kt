package com.example.coroutineslesson.presenter

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.coroutineslesson.presenter.ui.theme.CoroutinesLessonTheme
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutinesLessonTheme {
                MainScreen(
                    onButtonClick = {
//                        val job = GlobalScope.launch { longOperation() }
//                        job.cancel()

//                        val result = GlobalScope.async { longOperation() }
//                        result.await()

                        // start when onCreate, cancel when onDestroy
                        lifecycleScope.launch { longOperation() }
                    },
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //presenter.onDestroy()
    }
}

class MainFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // start when activity onCreate, cancel when activity onDestroy
        lifecycleScope.launch { longOperation() }

        // start when fragment onViewCreated, cancel when fragment onDestroyView
        viewLifecycleOwner.lifecycleScope.launch { longOperation() }
    }
}

class MainViewModel : ViewModel() {

    init {
        // start when viewModel created, cancel when viewModel cleared
        viewModelScope.launch() {
            try {
                longOperation()
            } catch (e: Exception) {
                // handle exception
            }

            longOperation()
        }
    }
}

abstract class BasePresenter {

    protected val presenterScope = MainScope()

    fun onDestroyView() {
        presenterScope.cancel()
    }
}

class MainPresenter : BasePresenter() {

    init {
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            // handle exception
        }
        presenterScope.launch(context = exceptionHandler) {
            // if throw exception, then handle it in exceptionHandler
            longOperation()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onButtonClick: () -> Unit = {},
) {
    LaunchedEffect(Unit) {
        val a = longOperationWithResult()
        println(a)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Coroutines Lesson") }
            )
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Text"
                )
            }
            OutlinedButton(
                onClick = onButtonClick,
            ) {
                Text(text = "Click me")
            }
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CoroutinesLessonTheme {
        MainScreen()
    }
}

suspend fun longOperation() {
    println("Start long operation")
    delay(5000)
    println("End long operation")
}

suspend fun longOperationWithResult(): Int {
    println("Start long operation")
    delay(5000)
    println("End long operation")
    return Random.nextInt()
}

interface TestService {

    val live: MutableLiveData<Response>
    val flow: MutableStateFlow<Response>

    //@GET("test")
    suspend fun test(): Response
    //{
//        live.value = Response("")
//        live.observe() {
//            it.data
//        }
//
//        GlobalScope.launch {
//            flow.collect {
//                it.data
//            }
//        }
    //}
}

data class Response(
    val data: String,
)

// Service (suspend) -> Repository (suspend) -> ViewModel (viewModelScope.launch { fetch and updateData() } ) -> Fragment (nothing)