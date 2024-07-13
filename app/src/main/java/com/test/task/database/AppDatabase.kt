package com.test.task.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MedicineEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicineDao(): MedicineDao
}