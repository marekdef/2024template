package pl.senordeveloper.template2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.senordeveloper.template2024.logging.Loggable
import pl.senordeveloper.template2024.logging.loggable
import pl.senordeveloper.template2024.ui.theme.Template2024Theme
import kotlin.reflect.KFunction0

class MainActivity : ComponentActivity(),
    Loggable by loggable<MainActivity>() {

        private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        d("onCreate({})", savedInstanceState)
        setContent {
            val uiState = mainViewModel.uiState.value
            Template2024Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(uiState = uiState,
                        onLoaded = mainViewModel::randomCard)
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    uiState: MainViewModel.UiState,
    onLoaded: () -> Unit = {}
) {
    when(uiState) {
        MainViewModel.UiState.Loading -> {
            Text(text = "Loading")
            LaunchedEffect(Unit) {
                onLoaded()
            }
        }
        is MainViewModel.UiState.Loaded -> {
            Text(uiState.json)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Template2024Theme {
        Greeting(uiState =  MainViewModel.UiState.Loading)
    }
}