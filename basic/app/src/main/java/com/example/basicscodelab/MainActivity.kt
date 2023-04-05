package com.example.basicscodelab

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme
import kotlin.math.exp

/**
* [Column]`: 세로 방향으로 자식 요소들을 배치하는 데 사용됩니다.
* [Row]: 가로 방향으로 자식 요소들을 배치하는 데 사용됩니다.
* [ElevatedButton]: 눌릴 때 표현이 바뀌는 버튼을 만드는 데 사용됩니다. 일반적
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 함수의 스타일을 지정하는 방법
            BasicsCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    MyApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
/*
    // Surface 및 MaterialTheme는 Material Design과 관련된 개념이며,
    // Material Design은 사용자 인터페이스와 환경을 만드는데 도움을 주는 디자인 시스템이다
    var expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
            ) {
                Text(text = "hello, ")
                Text(text = name)
            }
            ElevatedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }

    }
*/
    var expanded : Boolean by remember { mutableStateOf(false)}
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )


    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
            ){
                Text(text = "Hello, ")
                Text(text = name, style = MaterialTheme.typography.headlineMedium)
            }
            ElevatedButton(onClick = { expanded = !expanded}) {
                Text(if (expanded) "show less" else "Show more")
            }
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names : List<String> = List(1000) {"$it"}
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
        // Compose 에서 제공하는 스코를 가능한 리스ㅡㅌ 뷰(View) LazyColumn 을 사용하여 아이템 목록을 표시할 수 있습니다.
        LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
            items(items = names) { name ->
                Greeting(name = name)
            }
        }
    }
}

//@Composable
//private fun MyApp(
//    modifier: Modifier = Modifier,
//    names: List<String> = listOf("world", "Compddose", "Rog")
//) {
//    Column(modifier = modifier.padding(vertical = 4.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
//
//}
@Composable
fun MyApp(modifier: Modifier = Modifier) {

//    var shouldShowOnboarding =  remember { mutableStateOf(true) }
    // 상태유지를 위해 rememberSaveable을 사용하면 화면 회전시에도 상태 유지가 가능
    var shouldShowOnboarding = rememberSaveable { mutableStateOf(true) }
    Surface(modifier) {
        if (shouldShowOnboarding.value) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding.value = false })
        } else {
            Greetings()
        }
    }
}

// 안드로이드 스튜디오 미리보기

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}



@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicsCodelabTheme {
        Greetings()
    }
}

@Preview
@Composable
fun MyAppPreview() {
    BasicsCodelabTheme {
        MyApp(Modifier.fillMaxSize())
    }
}