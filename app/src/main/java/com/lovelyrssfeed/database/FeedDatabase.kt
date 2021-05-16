package com.lovelyrssfeed.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lovelyrssfeed.database.daos.FeedEntryDao
import com.lovelyrssfeed.database.daos.RSSEntryDao
import com.lovelyrssfeed.database.entities.FeedEntry
import com.lovelyrssfeed.database.entities.RSSEntry
import com.lovelyrssfeed.database.type_converters.Converters

@Database(entities = arrayOf(FeedEntry::class, RSSEntry::class), version = 1)
@TypeConverters(Converters::class)
abstract class FeedDatabase: RoomDatabase() {
    abstract fun feedDao(): FeedEntryDao
    abstract fun rssEntryDao(): RSSEntryDao
}