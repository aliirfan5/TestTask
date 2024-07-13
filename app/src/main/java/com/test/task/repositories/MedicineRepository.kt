package com.test.task.repositories

import com.test.task.database.MedicineDao
import com.test.task.database.MedicineEntity
import com.test.task.models.Medicine
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MedicineRepository @Inject constructor(private val medicineDao: MedicineDao) {
    suspend fun getAllMedicines(): List<Medicine> {
        return medicineDao.getAllMedicines().map { Medicine(it.name, it.dose, it.strength) }
    }

    suspend fun insertAll(medicines: List<Medicine>) {
        medicineDao.insertAll(*medicines.map { MedicineEntity(it.name, it.dose, it.strength) }.toTypedArray())
    }
}