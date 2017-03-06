package com.quiz.mnnit.wissen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
Button b1,b2;
    EditText e1,e2;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1=(Button)findViewById(R.id.login1);
        b2=(Button)findViewById(R.id.signup);
        e1=(EditText)findViewById(R.id.username);
        e2=(EditText)findViewById(R.id.password);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(login.this,"please fill the form", Toast.LENGTH_LONG).show();
                }
                else
                {
                    SQLiteDatabase data=openOrCreateDatabase("wiissn",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists userinfo (name varchar,password varchar)");
                    String s3="select * from userinfo where name='"+s1+"' and password='"+s2+"'";
                    Cursor cursor=data.rawQuery(s3,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(login.this,"THANK YOU FOR LOGGING", Toast.LENGTH_LONG).show();
                        Intent k=new Intent(login.this,MainActivity.class);
                        startActivity(k);

                    }
                    else
                    {

                    }

                }
            }
        });
       b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(login.this,sign.class);
                startActivity(j);

            }
        });
        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(login.this,MainActivity.class);
                startActivity(j);

            }
        });*/
    }
}
