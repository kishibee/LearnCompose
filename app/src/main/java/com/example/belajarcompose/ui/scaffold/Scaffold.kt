package com.example.belajarcompose.ui.scaffold

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.AlertDialogDefaults.titleContentColor
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.belajarcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExperimental() {
    var presses by remember {
        mutableStateOf(0)
    }
    var showMenu by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            "Center Top Bar",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                navigationIcon = {
                     IconButton(onClick = {}) {
                         Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                     }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
                    }
                    IconButton(onClick ={showMenu = !showMenu}) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { "Option" },
                            onClick = {}
                        )
                    }
                }
            )
        },
        bottomBar = {
                    BottomAppBar (
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary,
                        content = {
                            IconButton(onClick = {}) {
                                Icon(imageVector = Icons.Default.AddAPhoto, contentDescription = "Add Photo")
                            }
                            IconButton(onClick = {}) {
                                Icon(imageVector = Icons.Default.Home, contentDescription = "Back To Home")
                            }
                            IconButton(onClick = {}) {
                                Icon(imageVector = Icons.Default.Cached, contentDescription = "Cached")
                            }
                        }
                    )
               },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { presses++ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "take photo")
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text =
                    """
                        This is an example of a scaffold, It uses the Scaffold composable parameter to create fab, bottombar, topbar
                        
                        It also contains some bassic inner content, such as this text
                        
                        if you pressed the floating action button it will show in ($presses) times. 
                    """.trimIndent()
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ScaffoldExperimentPreview() {
    ScaffoldExperimental()
}
