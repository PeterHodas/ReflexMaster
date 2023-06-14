package com.example.reflexmaster.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Trieda ktorá vytvára a vracia inštanciu databázy, porovnáva a ak zistí žee inštancia je vytvorená vráti tu
 */
@Database(entities = [Score::class], version = 2, exportSchema = false)
abstract class ScoreDatabase: RoomDatabase() {
    abstract val scoreDatabaseDao: ScoreDatabaseDao
    companion object {
        // inštancia databazy
        @Volatile
        private var INSTANCE: ScoreDatabase? = null

        // funkcia na volanie databázy
        fun getInstance(context: Context): ScoreDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ScoreDatabase::class.java,
                        "score_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}