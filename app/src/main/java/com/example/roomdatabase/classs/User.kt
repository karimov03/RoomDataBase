package com.example.roomdatabase.classs

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class User {
    @PrimaryKey(autoGenerate = true)
    var id: Int? =null
    var name: String?=null
    var age: Int?=null

    constructor(name: String?, age: Int?) {
        this.name = name
        this.age = age
    }
}