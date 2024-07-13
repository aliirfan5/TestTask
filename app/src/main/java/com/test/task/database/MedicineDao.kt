package com.test.task.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicineDao {
    @Query("SELECT * FROM medicine")
    suspend fun getAllMedicines(): List<MedicineEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg medicines: MedicineEntity)
}