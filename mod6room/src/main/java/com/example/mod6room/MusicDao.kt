package com.example.mod6room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MusicDao {
    @Insert
    fun insertMusic(music: Music) : Long

    @Query("SELECT * FROM music")
    fun getAllMusic(): List<Music>

    @Query("SELECT * FROM music WHERE id = :id")
    fun getMusicById(id: Long): Music?


}