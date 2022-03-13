package com.example.composelearn

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
fun HelloWorld( name: String) {
    val context = LocalContext.current
    val expand = remember {
        mutableStateOf(false)
    }
    val extraPadding by animateDpAsState(
        if (expand.value) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )

    )
    Surface(
        color = MaterialTheme.colors.secondary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(14.dp)) {
            Column(modifier = Modifier
                .weight(2f)
                .padding(bottom = extraPadding.coerceAtLeast(0.dp))) {
                Text(text = "Hello, $name")
                Text(text = "Compose Learn Code")
            }
            Button(
                onClick = {
                    expand.value = !expand.value
                }
            ) {
//                Toast.makeText(context, "Button Pressed", Toast.LENGTH_SHORT).show()
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
//        HelloWorld("test")
        recycleList(createAList())
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
        "test1",
        "text2",
        "text2",
        "text2",
        "text2",
        "text2",
        "text2",
        )
}

@Composable
fun recycleList(names: List<String> = List(1000) { "$it" }) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            HelloWorld(name = name)
        }
    }
}