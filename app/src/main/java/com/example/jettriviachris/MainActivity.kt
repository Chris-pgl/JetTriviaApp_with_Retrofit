package com.example.jettriviachris

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jettriviachris.screens.QuestionViewModel
import com.example.jettriviachris.ui.theme.JetTriviaChrisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetTriviaChrisTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun MyApp(modifier: Modifier){

}

@Composable
fun TriviaHome( viewModel: QuestionViewModel = hiltViewModel()) {
    Questions(viewModel)
}

@Composable
fun Questions(viewModel: QuestionViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true){
        Log.d("Loading", "Questions: ...Loading... ")
    }else{
        Log.d("Loading", "Questions: Loading STOPPED..")
        questions?.forEach { questionItem ->
            Log.d("Result", "Questions: ${questionItem.question}")
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetTriviaChrisTheme {

    }
}