package com.test.task.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.task.models.Medicine
import com.test.task.repositories.MedicineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicineViewModel @Inject constructor(private val repository: MedicineRepository) : ViewModel() {
    private val _medicines = mutableStateOf(emptyList<Medicine>())
    var medicines :State<List<Medicine>> = _medicines
    init {
        viewModelScope.launch {
            _medicines.value = repository.getAllMedicines()
        }
        val list = listOf(
            Medicine("asprin","","500 mg"),
            Medicine("disprin","","500 mg"),
            Medicine("eso","","40 mg"),
            )
        insertMedicines(list)
    }

    private fun insertMedicines(medicines: List<Medicine>) {
        viewModelScope.launch {
            repository.insertAll(medicines)
            _medicines.value = repository.getAllMedicines()
        }
    }
}