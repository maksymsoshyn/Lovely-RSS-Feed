package com.lovelyrssfeed.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class RSSFeedWithEntries(
        @Embedded val feedEntry: FeedEntry,
        @Relation(
                parentColumn = "FeedId",
                entityColumn = "FeedOwnerId"
        )
        val rssEntries: List<RSSEntry>
)