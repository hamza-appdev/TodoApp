package com.example.room_database.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppbar(modifier: Modifier = Modifier) {

    TopAppBar(
        modifier= Modifier .padding(top = 35.dp, start = 6.dp, end = 6.dp)
            .clip(RoundedCornerShape(100.dp)),
        colors = TopAppBarColors(
            containerColor = Color(0xFFF3F2F2),
            scrolledContainerColor = Color.Transparent,
            navigationIconContentColor = Color.Black,
            titleContentColor = Color.Black,
            actionIconContentColor = Color.Black
        ),
        windowInsets = WindowInsets(top = 0.dp),
        navigationIcon = {
            Icon(Icons.Default.Menu, contentDescription = "",
                modifier= Modifier.padding(start = 8.dp)
            )
        },
        title = {
            Box(
                modifier= Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Room Database",
                    style = TextStyle(
                        fontSize = 20.sp)
                )
            }
        },

        actions = {
            Icon(Icons.Default.AccountBox, contentDescription = "",
                modifier= Modifier.padding(end = 13.dp))
        },
     )

}
