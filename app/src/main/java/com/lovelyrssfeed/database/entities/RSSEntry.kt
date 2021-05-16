package com.lovelyrssfeed.database.entities

import androidx.room.*
import java.util.*

@Entity
data class RSSEntry(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "RSSEntryId") val id: Int = 0,
    @ColumnInfo(name = "RSSEntryTitle") val title: String?,
    @ColumnInfo(name = "RSSEntryDescription") val description: String?,
    @ColumnInfo(name = "RSSEntryLink") val link: String?,
    @ColumnInfo(name = "CreationDate") val publicationDate: Date?,
    @ColumnInfo(name = "FeedOwnerId") val feedId: Int
)