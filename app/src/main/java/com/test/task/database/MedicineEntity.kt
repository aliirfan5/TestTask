package com.test.task.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicine")
data class MedicineEntity(
    @PrimaryKey val name: String,
    val dose: String,
    val strength: String
)