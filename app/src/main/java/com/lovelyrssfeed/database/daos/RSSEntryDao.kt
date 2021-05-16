package com.lovelyrssfeed.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lovelyrssfeed.database.entities.RSSEntry

@Dao
interface RSSEntryDao {
    @Insert
    fun insertAll(vararg rssEntries: RSSEntry)

    @Update
    fun updateEntry(rssEntry: RSSEntry)

    @Delete
    fun deleteEntry(rssEntry: RSSEntry)

    @Query("SELECT * FROM RSSEntry")
    fun getAll(): List<RSSEntry>

    @Query("SELECT * FROM RSSEntry WHERE RSSEntryId = :rssEntryId")
    fun getRssEntry(rssEntryId: Int): RSSEntry

    @Query("SELECT * FROM RSSEntry WHERE RSSEntryLink = :rssEntryLink")
    fun getRssEntryByLink(rssEntryLink: String): List<RSSEntry>
}