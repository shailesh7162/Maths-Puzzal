package com.example.maths_puzzal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Grid_Adpter extends BaseAdapter
{
    Level_Activity level_activity;
    List<Puzzles> puzzlesList;
    SharedPreferences preferences;

    TextView levelBtn;
    ImageView win;

    public Grid_Adpter(Level_Activity level_activity, List<Puzzles> puzzleslist)
    {
        this.level_activity=level_activity;
        this.puzzlesList=puzzleslist;
        preferences=level_activity.getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    @Override
    public int getCount() {
        return puzzlesList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = LayoutInflater.from(level_activity).inflate(R.layout.grid_item, viewGroup, false);

        levelBtn = view.findViewById(R.id.levelBtn);
        return view;
    }
}
