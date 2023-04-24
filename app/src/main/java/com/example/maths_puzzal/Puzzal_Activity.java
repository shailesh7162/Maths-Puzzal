package com.example.maths_puzzal;

import static com.example.maths_puzzal.MainActivity.PUZZLESLIST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Puzzal_Activity extends AppCompatActivity implements View.OnClickListener
{
    int level = 0;
    int chance = 3;

    TextView[] txtv = new TextView[10];
    ImageView puzzleBord, clearBtn, skipBtn;
    TextView puzzleNumber, ansTxtv, submitBtn;
    String n = "";
    long ans;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzal);

        if (getIntent().getExtras()!=null)
        {
            level=getIntent().getIntExtra("level",100);
        }
        preferences=getSharedPreferences("preferences",MODE_PRIVATE);
        editor=preferences.edit();

        puzzleBord = findViewById(R.id.puzzleBord);
        puzzleNumber = findViewById(R.id.puzzleNumber);
        ansTxtv = findViewById(R.id.ansTxtv);
        clearBtn = findViewById(R.id.clearBtn);
        submitBtn = findViewById(R.id.submitBtn);
        skipBtn = findViewById(R.id.skipBtn);

        for (int i=0;i<10;i++)
        {
            int id=getResources().getIdentifier("ans" +i,"id",getPackageName());
            txtv[i]=findViewById(id);
            txtv[i].setOnClickListener(this);
        }
        puzzleBord.setImageResource(PUZZLESLIST.get(level).getPuzzle());
        puzzleNumber.setText("puzzal" +(level +1));

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ansTxtv.getText().toString().length() >=1)
                {
                    n=n.substring(0,n.length() -1);
                    ansTxtv.setText(n);
                }
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!n.isEmpty())
                {
                    ans=Long.parseLong(ansTxtv.getText().toString());
                    if(ans==PUZZLESLIST.get(level).getAns)
                    {
                        editor.putInt("LastLevel",level);
                        editor.putString("levelStatus" + level,"win");
                        editor.commit();

                        Intent intent=new Intent(Puzzal_Activity.this,win_Activity.class);
                        intent.putExtra("win_leval",level);
                        startActivity(intent);
                        finish();
                    }
                }
            }

        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n="";
                ansTxtv.setText("");
                editor.putString("levelStatus" + level,"skip");
                if(level >=PUZZLESLIST.size() -1)
                {
                    editor.putInt("LastLevel",0);
                    level=0;
                }else
                {
                    editor.putInt("LastLevel",level);
                    level=level+1;
                }
                editor.commit();

                puzzleBord.setImageResource(PUZZLESLIST.get(level).getPuzzle());
                puzzleNumber.setText("puzzle" +(level+1));
            }
        });
    }

    @Override
    public void onClick(View view)
    {
        for (int i=0;i<10;i++)
        {
            if(view.getId()==txtv[i].getId())
            {
                n=n+txtv[i].getText().toString();
                ansTxtv.setText(n);
            }
        }
    }
}