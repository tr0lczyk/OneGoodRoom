package com.olczyk.android.atlastaproperroom;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DogDao {

    @Insert
    void insert(Dog dog);

    @Update
    void update(Dog dog);

    @Delete
    void delete(Dog dog);

    @Query("DELETE FROM dog_table")
    void deleteAllNotes();

    @Query("SELECT * FROM dog_table ORDER BY size DESC")
    LiveData<List<Dog>> getAllDogs();
}
