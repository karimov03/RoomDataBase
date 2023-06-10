package com.example.roomdatabase.Db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase.classs.User

@Dao
interface MyDao {
    @Query("select * from User")
    fun getAllUsers():List<User>

    @Insert
    fun addUser(user: User)
}