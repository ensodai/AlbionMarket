package com.example.albionmarket.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverter {

    @TypeConverter
    fun fromString(value: String): Map<String, String> {
        val type = object : TypeToken<Map<String, String>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toString(value: Map<String, String>): String {
        return Gson().toJson(value)
    }

}