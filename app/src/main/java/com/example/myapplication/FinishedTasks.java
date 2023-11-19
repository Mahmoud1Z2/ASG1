package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FinishedTasks extends AppCompatActivity {
    public static ArrayList<Task> finishArray = new ArrayList<>();
    public static ListView lstVF;
    private Button btnClear;
    public static ArrayList<String> arrayList2 = new ArrayList<>();
    //public static ArrayList<Task> finishedTask = new ArrayList<>();

    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_tasks);
        lstVF = findViewById(R.id.lstVF);
        btnClear = findViewById(R.id.btnClear);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickedC(view);
            }
        });
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,arrayList2);
        lstVF.setAdapter(adapter);
        lstVF.getAdapter().toString();
    }

    private void onClickedC(View view){
        arrayList2.clear();
        adapter.notifyDataSetChanged();

    };

}