package com.tedm.newscompose.domain.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tedm.newscompose.domain.local.entities.HistoryItem
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoryItem(historyItem: HistoryItem)

    @Query("DELETE FROM history WHERE id = :historyItemID")
    suspend fun deleteHistoryItemById(historyItemID: Int)

    @Query("SELECT * FROM history WHERE id = :historyItemID")
    suspend fun getHistoryItemById(historyItemID: String): HistoryItem?

    @Query("SELECT * FROM history ORDER BY id DESC")
    fun getAllHistoryItems(): Flow<List<HistoryItem>>

    @Query("SELECT Count(*) FROM history")
    fun getAllHistoryItemsQuantity() : Int

    @Query("SELECT MAX(id) FROM history")
    fun getMaxHistoryItemId() : Int?

    @Query("UPDATE history SET id = id - 1 ")
    fun updateHistory() : Int?

}