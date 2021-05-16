package com.lovelyrssfeed.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "FeedEntry")
data class FeedEntry(
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "FeedId") val feedId: Int = 0,
        @ColumnInfo(name = "FeedName") val feedName: String,
        @ColumnInfo(name = "CreationDate") val creationDate: Date?
)