package com.olczyk.android.atlastaproperroom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dog_table")
public class Dog {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private int size;


    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
