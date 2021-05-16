package com.lovelyrssfeed

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lovelyrssfeed.database.FeedDatabase
import com.lovelyrssfeed.database.daos.FeedEntryDao
import com.lovelyrssfeed.database.daos.RSSEntryDao
import com.lovelyrssfeed.database.entities.FeedEntry
import com.lovelyrssfeed.database.entities.RSSEntry
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import kotlin.jvm.Throws

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var db: FeedDatabase
    private lateinit var feedEntryDao: FeedEntryDao
    private lateinit var rssEntryDao: RSSEntryDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, FeedDatabase::class.java).build()
        feedEntryDao = db.feedDao()
        rssEntryDao = db.rssEntryDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb(){
        db.close()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.lovelyrssfeed", appContext.packageName)
    }

    @Test
    @Throws(Exception::class)
    fun writeFeedAndRead(){
        val feed1: FeedEntry = FeedEntry(feedId = 1, feedName = "TestFeed",creationDate = Calendar.getInstance().time)
        val feed2: FeedEntry = FeedEntry(feedId = 2, feedName = "TestFeed1", creationDate = Calendar.getInstance().time)
        val id = feedEntryDao.insertAll(feed1, feed2)
        print(id)
        val byName = feedEntryDao.getFeedByName(feed1.feedName)
        assertEquals(byName.get(0),feed1)
        assertEquals(2, feedEntryDao.getAll().size)
    }


    @Test
    @Throws(Exception::class)
    fun writeRssEntry(){
        val entry = RSSEntry(id = 1,
                title="TestEntry",
                description="ExampleDescription",
                publicationDate=Calendar.getInstance().time,
                feedId = 1,
                link = "https://stackoverflow.com")

        rssEntryDao.insertAll(entry)
        val byLink = entry.link?.let { rssEntryDao.getRssEntryByLink(it) }
        assertEquals(byLink?.get(0), entry)
    }


}