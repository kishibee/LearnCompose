package com.example.belajarcompose.ui.main

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.belajarcompose.R
import com.example.belajarcompose.ui.theme.BelajarComposeTheme

private val listName = listOf(
    "Akbar",
    "Saka",
    "Jeky",
    "Sage",
    "Galih",
    "Prima",
    "Aceng",
    "Payet",
    "acil",
    "tania",
    "argista",
    "bunda"
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarComposeTheme {
                HelloRaflyApp()
            }
        }
    }
}

@Composable
fun HelloRaflyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        GreetingList(listName)
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4, group = "ListPreview", uiMode = UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun HelloRaflyAppPreview() {
    BelajarComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            HelloRaflyApp()
            TopBar()
        }
    }
}


@Composable
fun GreetingList(names: List<String>) {
    if (names.isNotEmpty()) {
        LazyColumn{
            items(names){ name ->
                Greeting(name)
            }
        }
    } else {
        Text("No people to greet :)")
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val animatedSizeDp by animateDpAsState(
        targetValue = if (isExpanded) 140.dp else 100.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )
    TopBar()
    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .clickable(onClick = {}),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Logo Android",
                    modifier = modifier
                        .size(animatedSizeDp)
                        .clip(CircleShape)
                        .border(4.dp, Color.Black, RectangleShape)
                        .padding(10.dp)
                )
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Favorite",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                )
            }
            Spacer(modifier = modifier.width(10.dp))
            Column(
                modifier.weight(4f),
            ) {
                Text(
                    text = "Hello $name!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text = "Welcome to jetpack compose!",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(onClick = { isExpanded = !isExpanded }) {
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Outlined.ExpandMore,
                    contentDescription = if (isExpanded) "Show less" else "Show more"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    var showMenu by remember {
        mutableStateOf(false)
    }
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        title = {
            Text(text= "Penelitian")
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite")
            }
            IconButton(onClick = { showMenu = !showMenu}) {
                Icon(imageVector = Icons.Default.MoreVert,
                    contentDescription = "More")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
               DropdownMenuItem(
                   text = {"Hubungi"},
                   onClick = {}
               )
            }
        }
    )
}

