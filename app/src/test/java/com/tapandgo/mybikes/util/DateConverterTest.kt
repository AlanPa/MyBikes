package com.tapandgo.mybikes.util

import org.junit.Assert
import org.junit.Test

internal class DateConverterTest {

    @Test
    fun convertMillisToDateCorrectly() {
        val convertedDate = DateConverter.getDateFromMs(0L)
        Assert.assertEquals("01/01/1970 01:00", convertedDate)
    }
}