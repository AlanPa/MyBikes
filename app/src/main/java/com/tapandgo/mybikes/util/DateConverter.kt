package com.tapandgo.mybikes.util

import java.text.SimpleDateFormat

class DateConverter {
    companion object {
        fun getDateFromMs(millisecondsValue: Long): String {
            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
            return simpleDateFormat.format(millisecondsValue)
        }
    }

}