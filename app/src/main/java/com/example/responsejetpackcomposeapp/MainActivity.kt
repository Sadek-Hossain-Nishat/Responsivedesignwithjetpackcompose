package com.example.responsejetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.responsejetpackcomposeapp.ui.theme.ResponseJetpackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResponseJetpackComposeAppTheme {

                val windowInfo = rememberWindowInfo()
                if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {

                    LazyColumn(modifier = Modifier.fillMaxSize()) {


                        // list 1

                        items(10) {
                            Text(
                                text = "Itme $it",
                                fontSize = 25.sp,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Cyan)
                                    .padding(16.dp)
                            )
                        }

                        // list 2
                        items(10) {
                            Text(
                                text = "Itme $it",
                                fontSize = 25.sp,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Green)
                                    .padding(16.dp)
                            )

                        }

                    }

                } else {
                    Row(modifier= Modifier.fillMaxWidth()) {



                        LazyColumn(modifier = Modifier.weight(1f)) {


                            // list 1

                            items(10) {
                                Text(
                                    text = "Itme $it",
                                    fontSize = 25.sp,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Cyan)
                                        .padding(16.dp)
                                )
                            }



                        }


                        LazyColumn(modifier = Modifier.weight(1f)) {


                            // list 1

                            items(10) {
                                Text(
                                    text = "Itme $it",
                                    fontSize = 25.sp,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Green)
                                        .padding(16.dp)
                                )
                            }



                        }




                    }
                }

            }
        }
    }
}


@Composable
fun rememberWindowInfo(): WindowInfo {

    val configuration = LocalConfiguration.current
    return WindowInfo(

        screenWidthInfo = when {

            configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded


        },
        screenHeightInfo = when {

            configuration.screenHeightDp < 480 -> WindowInfo.WindowType.Compact
            configuration.screenHeightDp < 900 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded


        },
        screenWidth = configuration.screenWidthDp.dp,
        screenHeight = configuration.screenHeightDp.dp


    )

}


data class WindowInfo(
    val screenWidthInfo: WindowType,
    val screenHeightInfo: WindowType,
    val screenWidth: Dp,
    val screenHeight: Dp

) {
    sealed class WindowType {
        object Compact : WindowType()
        object Medium : WindowType()
        object Expanded : WindowType()
    }
}

