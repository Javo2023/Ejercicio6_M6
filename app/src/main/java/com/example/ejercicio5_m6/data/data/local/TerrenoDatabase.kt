package com.example.ejercicio5_m6.data.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [TerrenoEntity::class], version = 1)
abstract class TerrenoDatabase : RoomDatabase() {

    abstract fun getITerrenoDao(): TerrenoDao

    companion object {
        @Volatile
        private var INSTANCE: TerrenoDatabase? = null

        fun getDataBase(context: Context): TerrenoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TerrenoDatabase::class.java,
                    "terrenos_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}