package com.tedm.newscompose.domain.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tedm.newscompose.domain.local.entities.HistoryItem

@Database(
    entities = [HistoryItem::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class HistoryItemDatabase : RoomDatabase() {

    abstract fun historyItemDao(): HistoryItemDao
}