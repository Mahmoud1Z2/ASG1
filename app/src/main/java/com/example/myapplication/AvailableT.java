package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class AvailableT extends AppCompatActivity {

    private CheckBox checkBox;
    private TextView txtD,txtDate;
    private Button btnDone;
    public static ListView lstVA;
    
    public static String DATA ="DATA";
    public static ArrayList<String> arrayList = new ArrayList<>();
    //public static ArrayList<Task> finishedTask = new ArrayList<>();

    private ArrayAdapter<String> adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_t);
        lstVA = findViewById(R.id.lstVA);
        txtD = findViewById(R.id.txtD);
        btnDone = findViewById(R.id.btnDone);
        checkBox = findViewById(R.id.checkBox);
        txtDate = findViewById(R.id.txtDate);
        String disc = "";


        lstVA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 'position' parameter gives you the index of the clicked item
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Display a Toast with the selected item
                //Toast.makeText(AvailableT.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
                txtD.setText(selectedItem);
                String disc = "";
                String date ="";

                for (Task task : AddView.tasks) {
                    if (task.getTask().equals(selectedItem)) {
                        disc = task.getDiscreption();
                        date = task.getDate();
                        break;
                    }
                }
                txtD.setText(disc);
                txtDate.setText(date);

                String finalDisc = disc;
                String finalDate = date;
                btnDone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(checkBox.isChecked()){
                            FinishedTasks.arrayList2.add(selectedItem);
                            FinishedTasks.finishArray.add(new Task(selectedItem, finalDisc, finalDate));
                                    // Remove the item from the ArrayList
                            arrayList.remove(position);
                                    // Notify the adapter that the data set has changed
                            adapter.notifyDataSetChanged();
                            txtD.setText("");
                            txtDate.setText("");
                            checkBox.setChecked(false);

                        }
                    }
                });
            }

        });


        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,arrayList);
        lstVA.setAdapter(adapter);
        lstVA.getAdapter().toString();

    }

//    private void onClickedDone(View view){
//        if(checkBox.isSelected());{
//
//        }
//    };



}