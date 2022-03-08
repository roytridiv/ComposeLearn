package com.example.composelearn

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelearn.ui.theme.ComposeLearnTheme
import kotlin.coroutines.coroutineContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme {
                myApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    //Tweaking the UI
    Surface(
        color = MaterialTheme.colors.secondary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        Column(modifier = Modifier.wrapContentSize(Alignment.Center)) {
            for (item in createAList()) {
                Column(modifier = Modifier.padding(2.dp)) {
                    Text(text = item)
                }
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = "test 1")
                Text(text = "test 2")
            }


            Text(
                text = "Hello $name!",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            )
        }

    }

}

@Composable
fun HelloWorld() {
    val context = LocalContext.current
    val expand = remember {
        mutableStateOf(false)
    }
    val extraPadding = if (expand.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colors.secondary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(14.dp)) {
            Row (modifier = Modifier.weight(2f).padding(top = extraPadding, bottom = 20.dp)) {
                Text(text = "Hello, ")
                Text(text = "Compose Learn Code")
            }
            Button(
                onClick = {
                    expand.value = !expand.value

                }
            ) {
                Toast.makeText( context, "Button Pressed", Toast.LENGTH_SHORT).show()
                Text(if (expand.value) "Show less" else "Show more")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 300)
@Composable
fun DefaultPreview() {
    ComposeLearnTheme {
        myApp()
    }
}

@Composable
fun myApp() {
    Surface(color = MaterialTheme.colors.background) {
        HelloWorld()
    }
}

fun createAList(): MutableList<String> {
    return mutableListOf(
        "test1",
        "text2",
        "text2",
        "text2",
        "text2",
        "text2",
        "text2",

        )
}