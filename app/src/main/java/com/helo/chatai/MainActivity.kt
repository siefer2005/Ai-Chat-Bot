package com.helo.chatai
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.helo.chatai.ui.theme.ChatAiTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    private val viewModel: ChatViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var keepSplashScreenOnScreen = true
        CoroutineScope(Dispatchers.Main).launch {
            delay(1500)
            keepSplashScreenOnScreen = false
        }
        splashScreen.setKeepOnScreenCondition { keepSplashScreenOnScreen }


        setContent {

            ChatAiTheme {
                AppNavigation()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   AppNavigation()
                }
            }
        }
    }
}
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "ChatPage") {

        composable("ChatPage") {
            val viewModel = ChatViewModel()
            ChatPage(viewModel = viewModel)
        }
    }
}





