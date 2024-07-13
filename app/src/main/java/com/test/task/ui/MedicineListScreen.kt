package com.test.task.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.test.task.models.Medicine
import com.test.task.viewModels.MedicineViewModel
import java.util.Calendar

@Composable
fun MedicineListScreen(
    navController: NavController,
    username: String,
    viewModel: MedicineViewModel = hiltViewModel()
) {
    val medicines by viewModel.medicines

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        val greeting = getGreeting()
        Text("Hello, $username! $greeting")
        LazyColumn {
            items(medicines) { medicine ->
                MedicineCard(medicine) {
                    navController.navigate("medicine_detail/${medicine.name}")
                }
            }
        }
    }
}

@Composable
fun MedicineCard(medicine: Medicine, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp).clickable { onClick() }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Name: ${medicine.name}", fontWeight = FontWeight.Bold, color = Color.Black)
            Text("Dose: ${medicine.dose}", color = Color.Black)
            Text("Strength: ${medicine.strength}", color = Color.Black)
        }
    }
}

fun getGreeting(): String {
    val c = Calendar.getInstance()
    val hour = c.get(Calendar.HOUR_OF_DAY)

    return when (hour) {
        in 5..11 -> "Good Morning"
        in 12..16 -> "Good Afternoon"
        in 17..20 -> "Good Evening"
        else -> "Good Night"
    }
}


