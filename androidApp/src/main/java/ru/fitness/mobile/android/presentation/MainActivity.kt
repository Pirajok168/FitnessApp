package ru.fitness.mobile.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.fitness.mobile.android.presentation.navigation.RootGraph
import ru.fitness.mobile.android.presentation.theme.AppTheme
import ru.fitness.mobile.presentation.view_model_factory.LocalOwnerViewModel
import ru.fitness.mobile.presentation.view_model_factory.OwnerViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AppTheme(dynamicColor = false) {
                CompositionLocalProvider(LocalOwnerViewModel provides OwnerViewModel()) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        RootGraph()
                    }
                }

            }
        }
    }
}


