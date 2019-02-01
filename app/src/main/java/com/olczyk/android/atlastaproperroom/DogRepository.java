package com.olczyk.android.atlastaproperroom;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class DogRepository {
    private DogDao dogDao;
    private LiveData<List<Dog>> allDogs;

    public DogRepository(Application application){
        DogDatabase database = DogDatabase.getInstance(application);
        dogDao = database.dogDao();
        allDogs = dogDao.getAllDogs();
    }

    public void insert(Dog dog){
        new InsertDogAsyncTask(dogDao).execute(dog);
    }

    public void update(Dog dog){

    }

    public void delete(Dog dog){

    }

    public void deleteAllDogs(){

    }

    public LiveData<List<Dog>> getAlldogs(){
        return allDogs;
    }

    private static class InsertDogAsyncTask extends AsyncTask<Dog,Void, Void> {
        private DogDao dogDao;

        private InsertDogAsyncTask(DogDao dogDao){
            this.dogDao = dogDao;
        }

        @Override
        protected Void doInBackground(Dog... dogs) {
            dogDao.insert(dogs[0]);
            return null;
        }
    }
}
