package com.quiz.mnnit.wissen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Category extends AppCompatActivity {


    Button gk,books,films,music,computer,sports,geography,history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        gk=(Button)findViewById(R.id.gk);
        books=(Button)findViewById(R.id.books);
        films=(Button)findViewById(R.id.films);
        music=(Button)findViewById(R.id.music);
        computer=(Button)findViewById(R.id.computer);
        sports=(Button)findViewById(R.id.sports);
        geography=(Button)findViewById(R.id.geography);
        history=(Button)findViewById(R.id.history);
        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Category.this,MainActivity.class);
                intent.putExtra("cat","9");
                startActivity(intent);
            }
        });
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Category.this,MainActivity.class);
                intent.putExtra("cat","10");
                startActivity(intent);
            }
        });
        films.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Category.this,MainActivity.class);
                intent.putExtra("cat","11");
                startActivity(intent);
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Category.this,MainActivity.class);
                intent.putExtra("cat","12");
                startActivity(intent);
            }
        });
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Category.this,MainActivity.class);
                intent.putExtra("cat","18");
                startActivity(intent);
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Category.this,MainActivity.class);
                intent.putExtra("cat","21");
                startActivity(intent);
            }
        });
        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Category.this,MainActivity.class);
                intent.putExtra("cat","22");
                startActivity(intent);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Category.this,MainActivity.class);
                intent.putExtra("cat","23");
                startActivity(intent);
            }
        });
    }
}
