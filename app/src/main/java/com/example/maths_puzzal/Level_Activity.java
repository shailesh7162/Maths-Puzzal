package com.example.maths_puzzal;

import static com.example.maths_puzzal.MainActivity.PUZZLESLIST;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;


public class Level_Activity extends AppCompatActivity
{
    GridView grid;
    Grid_Adpter grid_adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        grid = findViewById(R.id.grid);
        grid_adpter = new Grid_Adpter(Level_Activity.this, PUZZLESLIST);
        grid.setAdapter( grid_adpter);
    }
}