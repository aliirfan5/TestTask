package com.test.task.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.test.task.viewModels.MedicineViewModel

@Composable
fun MedicineDetailScreen(name: String, viewModel: MedicineViewModel = hiltViewModel()) {
    val medicine = viewModel.medicines.value.firstOrNull { it.name == name }

    medicine?.let {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text("Name: ${it.name}", fontWeight = FontWeight.Bold, color = Color.Black)
            Text("Dose: ${it.dose}")
            Text("Strength: ${it.strength}")
        }
    }
}