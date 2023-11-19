package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnA,btnF,btnAdd2;

//    private SharedPreferences prefs;
//    private SharedPreferences.Editor editor;
    public static final String NAME = "NAME";
    public static String DATA = "DATA";
    public  static SharedPreferences prefs;
    public static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnA = findViewById(R.id.btnA);
        btnF = findViewById(R.id.btnF);
        btnAdd2 = findViewById(R.id.btnAdd2);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onClickedA(view);
            }
        });

        btnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickedAdd(view);
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickedF(view);
            }
        });

    }

    private void onClickedA(View view){

        Gson gson = new Gson();
        Intent intent;
        intent = new Intent(this,AvailableT.class);
        startActivity(intent);
    };

    private void onClickedAdd(View view){
        Intent intent;
        intent = new Intent(this,AddView.class);
        startActivity(intent);
    };
    private void onClickedF(View view){
        Intent intent;
        intent = new Intent(this,FinishedTasks.class);
        startActivity(intent);
    };
}