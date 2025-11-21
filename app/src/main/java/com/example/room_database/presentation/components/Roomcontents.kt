package com.example.room_database.presentation.components


import android.icu.util.Calendar
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.room_database.viewmodel.DatabaseViewModel
import com.example.roomdatabase_pratice.database.dataModel

@Composable
fun Roomcontents(
    modifier: Modifier = Modifier,
    viewModel: DatabaseViewModel,
    isdialoageopen: Boolean,
    ondialoagedismiss:()->Unit

) {

    val context = LocalContext.current
    var takename by remember { mutableStateOf("") }
    var takedescription by remember { mutableStateOf("") }

    val tasklist by viewModel.tasklist.observeAsState(emptyList())

    if (isdialoageopen){
        AlertDialog(
            onDismissRequest = {ondialoagedismiss()},
            title = {
                Text("Add New Task",
                    fontSize = 24.sp)
            },
            text = {
                Column {
                    OutlinedTextField(
                        value = takename,
                        onValueChange = { takename = it },
                        label = { Text(text = "Task Name") },
                        modifier= Modifier.padding(horizontal = 5.dp, vertical = 10.dp)

                    )
                    OutlinedTextField(
                        value = takedescription,
                        onValueChange = { takedescription = it },
                        label = { Text(text = "Task Description") },
                        modifier= Modifier.padding(horizontal = 5.dp, vertical = 10.dp)
                    )
                }

            },
            confirmButton = {
                Button(onClick = {
                    if(takename.isEmpty() || takedescription.isEmpty()){
                        Toast.makeText(context,"Field is empty", Toast.LENGTH_SHORT).show()
                    }else{
                        viewModel.addNewTask(
                            dataModel(
                                Calendar.getInstance().timeInMillis.toInt(),
                               name = takename,
                                description =takedescription
                            )
                        )
                        Toast.makeText(context,"Successfully Added", Toast.LENGTH_SHORT).show()
                        ondialoagedismiss()
                        takename=""
                        takedescription=""
                    }
                }) {
                    Text("Add")
                }
            },
            dismissButton = {
                Button(onClick = {ondialoagedismiss()}) {
                    Text("Cancel")
                }

            },

            containerColor = Color.White

            )}


    LazyColumn(
        modifier= Modifier.padding(10.dp)
    ) {
        items(
            items = tasklist, key = {it.id },
        ){task->
            RoomCard(task =task, viewModel=viewModel)
        }
    }
}
