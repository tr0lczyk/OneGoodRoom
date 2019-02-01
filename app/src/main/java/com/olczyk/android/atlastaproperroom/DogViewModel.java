package com.olczyk.android.atlastaproperroom;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class DogViewModel extends AndroidViewModel {

    private DogRepository dogRepository;
    private LiveData<List<Dog>> allDogs;

    public DogViewModel(@NonNull Application application) {
        super(application);
        dogRepository = new DogRepository(application);
        allDogs = dogRepository.getAlldogs();
    }

    public void insert(Dog dog){
        dogRepository.insert(dog);
    }

    public void update(Dog dog){

    }

    public void delete(Dog dog){

    }

    public void deleteAllDogs(){

    }

    public LiveData<List<Dog>> getAlldogs(){
        return dogRepository.getAlldogs();
    }
}
