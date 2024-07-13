package com.test.task.di

import android.app.Application
import androidx.room.Room
import com.test.task.database.AppDatabase
import com.test.task.database.MedicineDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "RoomDbMedicines.db").build()
    }

    @Provides
    fun provideMedicineDao(db: AppDatabase): MedicineDao {
        return db.medicineDao()
    }
}