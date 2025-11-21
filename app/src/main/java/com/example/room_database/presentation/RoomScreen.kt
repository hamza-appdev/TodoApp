package com.example.room_database.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.room_database.presentation.components.Roomcontents
import com.example.room_database.presentation.components.TopAppbar
import com.example.room_database.viewmodel.DatabaseViewModel

@Composable
fun RoomScreen(modifier: Modifier = Modifier,viewModel: DatabaseViewModel) {
    var isdialoageopen by remember { mutableStateOf(false) }
    Scaffold(
        containerColor = Color.White,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isdialoageopen=true
                },
                containerColor = Color.White,
                modifier = Modifier.padding(end = 16.dp, bottom = 45.dp)
            ) {
                Icon(
                    Icons.Default.Add, contentDescription = "",
                    modifier.size(27.dp)
                )
            }
        }
    ) {innerpadding->
        Column() {
            TopAppbar(modifier= Modifier.padding(innerpadding))
            Roomcontents(
                modifier= Modifier,
                viewModel=viewModel,
                isdialoageopen =isdialoageopen,
                ondialoagedismiss = {isdialoageopen=false}
            )

        }
    }

}