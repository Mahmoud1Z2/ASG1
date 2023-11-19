package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R.id;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;

public class AddView extends AppCompatActivity {
    static String MSG_NAME = "";
    private EditText edtName,edtDis;
    private EditText edtDate;
    private Button btnAddd;

    public static ArrayList<Task> tasks = new ArrayList<>();

    public  static SharedPreferences prefs;
    public static SharedPreferences.Editor editor;
    public static final String NAME = "NAME";
    public static String DATA = "DATA";
    private boolean flag = false;

    public static final String FLAG = "FLAG";
    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);

        edtName = findViewById(R.id.edtName);
        edtDis = findViewById(R.id.edtDis);
        edtDate = findViewById(R.id.edtDate);
        btnAddd = findViewById(R.id.btnAddd);

//        setupSharedPrefs();
//        checkPrefs();

        btnAddd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickedAdd(view);
            }
        });
    }


    public void onClickedAdd(View view){
        String name = edtName.getText().toString();
        String dis = edtDis.getText().toString();
        String date = edtDate.getText().toString();

        AvailableT.arrayList.add(name);
        tasks.add(new Task(name,dis,date));

        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();

        Gson gson = new Gson();
        String json = gson.toJson(tasks);

        editor.putString(DATA, json);
        editor.commit();


        Intent intent;
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    };

    private void  setupSharedPrefs(){
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }


}