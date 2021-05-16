package com.lovelyrssfeed.database.daos

import androidx.room.*
import com.lovelyrssfeed.database.entities.FeedEntry
import com.lovelyrssfeed.database.entities.RSSFeedWithEntries

@Dao
interface FeedEntryDao {

    @Insert
    fun insertAll(vararg feedEntry: FeedEntry): List<Long>

    @Update
    fun updateEntry(feedEntry: FeedEntry)

    @Delete
    fun deleteEntry(feedEntry: FeedEntry)

    @Query("SELECT * FROM FeedEntry")
    fun getAll(): List<FeedEntry>

    @Query("SELECT * FROM FeedEntry WHERE FeedId = :feedId")
    fun getFeed(feedId: Int): FeedEntry

    @Query("SELECT * FROM FeedEntry WHERE FeedName = :feedName")
    fun getFeedByName(feedName: String): List<FeedEntry>

    @Query("SELECT * FROM FeedEntry")
    fun getFeedWithEntries(): List<RSSFeedWithEntries>
}