package com.myapplicationdev.android.practicalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Tasks> al;
    ArrayAdapter<Tasks> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = this.findViewById(R.id.lvTask);

        al = new ArrayList<Tasks>();
        al.add(new Tasks("Item: 1","Description: Group discussion", "Date: 1 May 2021"));
        al.add(new Tasks("Item: 2","Description: Assignment submission", "Date: 5 May 2021"));
        al.add(new Tasks("Item: 3","Description: Online course", "Date: 19 May 2021"));

        aa = new TasksAdapter(this,R.layout.row,al);
        lv.setAdapter(aa);

    }
}