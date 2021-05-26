package com.example.arraylist2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.mylistview);
        EditText editText=findViewById(R.id.editTextName);
        Button button=findViewById(R.id.Insert);

        final ArrayList<String> friendArrayList=new ArrayList<String>();
        friendArrayList.add("Mnah");
        friendArrayList.add("nah1");
        friendArrayList.add("Bmnah2");
        friendArrayList.add("Amnah3");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,friendArrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Log.i("You Clicked", friendArrayList.get(i));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametoinsert=editText.getText().toString();
                friendArrayList.add(nametoinsert);
                arrayAdapter.notifyDataSetChanged();
                Collections.sort(friendArrayList);
            }
        });
    }
}




