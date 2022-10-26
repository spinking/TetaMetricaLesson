package studio.eyesthetics.tetametricalesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import studio.eyesthetics.tetametricalesson.ui.home.HomeScreen
import studio.eyesthetics.tetametricalesson.ui.theme.TetaMetricaLessonTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TetaMetricaLessonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen(
                        onSetUserIdClick = {
                            AnalyticsManager.selectUserId(it)
                        },
                        onSendEvent = {
                            AnalyticsManager.sendEvent(it)
                        }
                    )
                }
            }
        }
    }
}