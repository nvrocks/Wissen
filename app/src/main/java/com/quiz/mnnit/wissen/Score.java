package com.quiz.mnnit.wissen;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    Button retry,mainMenu;
    TextView textScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        retry=(Button)findViewById(R.id.retry);
        mainMenu=(Button)findViewById(R.id.mainMenu);
        textScore=(TextView)findViewById(R.id.textScore);
        String sc=getIntent().getStringExtra("score");
        textScore.setText(sc);
        Typeface font= Typeface.createFromAsset(getAssets(),"fontawesome-webfont.ttf");
        textScore.setTypeface(font);
        retry.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view)
            {
                Intent intent=new Intent(Score.this,Category.class);
                startActivity(intent);
            }

        });
    }
}
