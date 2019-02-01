package com.olczyk.android.atlastaproperroom;
import androidx.sqlite.db.SupportSQLiteDatabase;
import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Dog.class}, version = 1, exportSchema = false)
public abstract class DogDatabase extends RoomDatabase {

    private static DogDatabase instance;
    public abstract DogDao dogDao();

    public static synchronized DogDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),DogDatabase.class,"dog_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private DogDao dogDao;

        private PopulateDbAsyncTask(DogDatabase db){
            dogDao = db.dogDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dogDao.insert(new Dog("Title 1", 1));
            dogDao.insert(new Dog("Title 2", 2));
            dogDao.insert(new Dog("Title 3", 3));
            return null;
        }
    }
}
