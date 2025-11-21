package com.example.room_database.presentation.components

import android.icu.util.Calendar
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.room_database.viewmodel.DatabaseViewModel
import com.example.roomdatabase_pratice.database.dataModel

@Composable
fun RoomCard(
    viewModel: DatabaseViewModel,
    task: dataModel
) {
    val context = LocalContext.current
    var Edittakename by remember { mutableStateOf(task.name) }
    var Edittakedescription by remember { mutableStateOf(task.description) }
    var isEditdialoageopen by remember { mutableStateOf(false) }


    if (isEditdialoageopen){
        AlertDialog(
            onDismissRequest = {isEditdialoageopen=false},
            title = {
                Text("Update Task",
                    fontSize = 24.sp)
            },
            text = {
                Column {
                    OutlinedTextField(
                        value = Edittakename,
                        onValueChange = { Edittakename = it },
                        label = { Text(text = "Task Name") },
                        modifier= Modifier.padding(horizontal = 5.dp, vertical = 10.dp)

                    )
                    OutlinedTextField(
                        value = Edittakedescription,
                        onValueChange = { Edittakedescription = it },
                        label = { Text(text = "Task Description") },
                        modifier= Modifier.padding(horizontal = 5.dp, vertical = 10.dp)
                    )
                }

            },
            confirmButton = {
                Button(onClick = {
                    if(Edittakename.isEmpty() || Edittakedescription.isEmpty()){
                        Toast.makeText(context,"Field is empty", Toast.LENGTH_SHORT).show()
                    }else{
                        viewModel.editTask(
                            task.id,
                            Edittakename,
                            Edittakedescription
                        )
                        Toast.makeText(context,"Successfully Updated", Toast.LENGTH_SHORT).show()
                        isEditdialoageopen=false

                    }
                }) {
                    Text("Update")
                }
            },
            dismissButton = {
                Button(onClick = {isEditdialoageopen}) {
                    Text("Cancel")
                }

            },

            containerColor = Color.White

        )}

    Card(
        modifier= Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier= Modifier.padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(Modifier.weight(1f)) {
                Text(text = task.name, fontWeight = FontWeight.Bold, fontSize = 21.sp)
                Text(text = task.description, color = Color.Gray, fontSize = 16.sp)
            }
            Column() {
                Icon(Icons.Default.Edit, contentDescription = "",
                    modifier = Modifier.clickable{
                        isEditdialoageopen=true
                    }
                    )
                Spacer(Modifier.height(5.dp))
                Icon(Icons.Default.Delete, contentDescription = "",
                    modifier = Modifier.clickable{
                        viewModel.removeTask(task.id)
                        Toast.makeText(context, "Task Deleted", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }

    }
}