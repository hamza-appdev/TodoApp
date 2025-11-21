package com.example.room_database

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.room_database.presentation.RoomScreen
import com.example.room_database.ui.theme.Room_DatabaseTheme
import com.example.room_database.viewmodel.DatabaseViewModel

class MainActivity : ComponentActivity() {
    private lateinit var databaseViewModel: DatabaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        databaseViewModel = ViewModelProvider(this)[DatabaseViewModel::class.java]
        setContent {
            Room_DatabaseTheme {
                RoomScreen(viewModel = databaseViewModel)
            }
        }
    }
}

