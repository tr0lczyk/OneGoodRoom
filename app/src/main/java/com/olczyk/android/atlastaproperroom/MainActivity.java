package com.olczyk.android.atlastaproperroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Application;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DogViewModel dogViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dogViewModel = ViewModelProviders.of(this).get(DogViewModel.class);
        dogViewModel.getAlldogs().observe(this, new Observer<List<Dog>>() {
            @Override
            public void onChanged(List<Dog> dogs) {

            }
        });
    }
}
