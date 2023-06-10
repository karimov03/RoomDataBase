package com.example.roomdatabase.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.classs.User


@Database(entities = [User::class], version = 1)
abstract class MyDbHelp :RoomDatabase(){
    abstract fun userDao():MyDao
    companion object {
        fun newInstanse(context: Context): MyDbHelp {
            val db = Room.databaseBuilder(
                context.applicationContext,
                MyDbHelp::class.java, "databasse_name"
            ).allowMainThreadQueries().build()
            return db
        }
    }


}