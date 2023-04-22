package com.example.maths_puzzal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    TextView continueBtn, puzzlesBtn;
    public static List<Puzzles> PUZZLESLIST = new ArrayList<>();
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        int level = preferences.getInt("LastLevel", -1);
        continueBtn = findViewById(R.id.continueBtn);
        puzzlesBtn = findViewById(R.id.puzzlesBtn);

        PUZZLESLIST.clear();
        PUZZLESLIST.add(new Puzzles(R.drawable.p1, 10));
        PUZZLESLIST.add(new Puzzles(R.drawable.p2, 25));
        PUZZLESLIST.add(new Puzzles(R.drawable.p3, 6));
        PUZZLESLIST.add(new Puzzles(R.drawable.p4, 14));
        PUZZLESLIST.add(new Puzzles(R.drawable.p5, 128));
        PUZZLESLIST.add(new Puzzles(R.drawable.p6, 7));
        PUZZLESLIST.add(new Puzzles(R.drawable.p7, 50));
        PUZZLESLIST.add(new Puzzles(R.drawable.p8, 1025));
        PUZZLESLIST.add(new Puzzles(R.drawable.p9, 100));
        PUZZLESLIST.add(new Puzzles(R.drawable.p10, 3));
        PUZZLESLIST.add(new Puzzles(R.drawable.p11, 212));
        PUZZLESLIST.add(new Puzzles(R.drawable.p12, 3011));
        PUZZLESLIST.add(new Puzzles(R.drawable.p13, 14));
        PUZZLESLIST.add(new Puzzles(R.drawable.p14, 16));
        PUZZLESLIST.add(new Puzzles(R.drawable.p15, 1));
        PUZZLESLIST.add(new Puzzles(R.drawable.p16, 2));
        PUZZLESLIST.add(new Puzzles(R.drawable.p17, 44));
        PUZZLESLIST.add(new Puzzles(R.drawable.p18, 45));
        PUZZLESLIST.add(new Puzzles(R.drawable.p19, 625));
        PUZZLESLIST.add(new Puzzles(R.drawable.p20, 1));

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Puzzal_Activity.class);
                intent.putExtra("level", level + 1);
                startActivity(intent);
            }
        });
        puzzlesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Level_Activity.class));
            }
        });
    }

}