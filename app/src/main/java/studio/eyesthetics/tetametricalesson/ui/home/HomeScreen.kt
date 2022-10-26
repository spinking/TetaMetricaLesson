package studio.eyesthetics.tetametricalesson.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import studio.eyesthetics.tetametricalesson.ui.theme.ColorBlackShark
import studio.eyesthetics.tetametricalesson.ui.theme.ColorGray
import studio.eyesthetics.tetametricalesson.ui.theme.ColorRedMonzaLight
import java.lang.RuntimeException
import java.util.*

@Composable
fun HomeScreen(
    onSetUserIdClick: (String) -> Unit,
    onSendEvent: (String) -> Unit
) {
    val userId = remember { mutableStateOf(HomeScreenCompanionObject.NO_USER_ID) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        TextButton(
            onClick = {
                userId.value = HomeScreenCompanionObject.USER_ID
                onSetUserIdClick.invoke(userId.value)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (userId.value == HomeScreenCompanionObject.NO_USER_ID) ColorGray else ColorRedMonzaLight,
                contentColor = ColorBlackShark
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }

        TextButton(
            onClick = {
                userId.value = HomeScreenCompanionObject.NO_USER_ID
                onSetUserIdClick.invoke(userId.value)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (userId.value == HomeScreenCompanionObject.USER_ID) ColorGray else ColorRedMonzaLight,
                contentColor = ColorBlackShark
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Logout")
        }

        TextButton(
            onClick = {
                onSendEvent.invoke("Some test event")
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = ColorRedMonzaLight,
                contentColor = ColorBlackShark
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Send Event")
        }

        TextButton(
            onClick = {
                throw RuntimeException("Test crash")
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = ColorRedMonzaLight,
                contentColor = ColorBlackShark
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Simulate Crash")
        }
    }
}

object HomeScreenCompanionObject {
    const val NO_USER_ID = "NO_USER_ID"
    const val USER_ID = "SOME_USER_ID"
}