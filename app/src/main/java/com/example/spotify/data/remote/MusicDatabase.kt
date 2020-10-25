package com.example.spotify.data.remote

import com.example.spotify.data.etities.Song
import com.example.spotify.other.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {
    private val fireSore=FirebaseFirestore.getInstance()
    private val songCollection = fireSore.collection(SONG_COLLECTION)


    suspend fun getAllSongs():List<Song>{
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}