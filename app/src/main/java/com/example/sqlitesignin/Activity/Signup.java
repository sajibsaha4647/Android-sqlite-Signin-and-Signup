package com.example.sqlitesignin.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sqlitesignin.R;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}