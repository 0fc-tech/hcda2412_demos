package com.example.mod6room

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MusicDbTest {
    lateinit var db : AppDatabase
    @Before
    fun createDb(){
        //créer BDD pour test
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
    }
    @Test
    fun testInsertMusic(){
        //création d'un pokemon et teste de son insertion
        val music = Music(0L, "Test", "Test author", 100)
        val id = db.musicDao().insertMusic(music)

        assertTrue("Mauvaise musique !", db.musicDao().getMusicById(id)?.author
                == music.author)
    }
}