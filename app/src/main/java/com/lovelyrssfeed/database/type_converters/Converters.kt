package com.lovelyrssfeed.database.type_converters

import android.annotation.SuppressLint
import androidx.room.TypeConverter
import com.lovelyrssfeed.RSS_ITEM_PUB_DATE_FORMAT
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.util.*

class Converters {
    @SuppressLint("SimpleDateFormat")

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? = value?.let { Date(value) }

    @TypeConverter
    fun toTimestamp(date: Date?) : Long? = date?.let {  date.time.toLong() }
}