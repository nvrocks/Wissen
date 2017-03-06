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

public class sign extends AppCompatActivity {
    int flag;
 Button b1,b2;
    EditText e1,e2,e3,e4,e5,e6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        b1 = (Button)findViewById(R.id.signup1);
        b2 = (Button)findViewById(R.id.bk);
        e1 = (EditText)findViewById(R.id.user1);
        e2 = (EditText)findViewById(R.id.pass1);
        e3 = (EditText)findViewById(R.id.passconfrm);
        e4 = (EditText)findViewById(R.id.email);
        e5 = (EditText)findViewById(R.id.city);
        e6 = (EditText)findViewById(R.id.phone);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 1;
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();

                if(!s3.equals(s2))
                {
                    Toast.makeText(sign.this, "Password dont Match", Toast.LENGTH_SHORT).show();
                    flag  = 0;
                }
                if(s2.length()<8)
                {
                    Toast.makeText(sign.this,"PassWord less Than 8 Characters", Toast.LENGTH_SHORT).show();
                    flag = 0;
                }
                if(s6.length()<10)
                {
                    Toast.makeText(sign.this,"Invalid Phone Number", Toast.LENGTH_SHORT).show();
                    flag = 0;
                }

                SQLiteDatabase data = openOrCreateDatabase("wiissn",MODE_PRIVATE,null);
                data.execSQL("create table if not exists userinfo (name varchar, password varchar, email varchar, city varchar, phone varchar)");
                String check1 = "select * from userinfo where name='"+s1+"'";
                Cursor cursor1 = data.rawQuery(check1,null);
                if(cursor1.getCount()>0)
                {
                    Toast.makeText(sign.this,"Username Registered", Toast.LENGTH_SHORT).show();
                    flag = 0;
                }

                String check2 = "select * from userinfo where email='"+s4+"'";
                Cursor cursor2 = data.rawQuery(check2,null);
                if(cursor2.getCount()>0)
                {
                    Toast.makeText(sign.this,"E-Mail Already Registered", Toast.LENGTH_SHORT).show();
                    flag = 0;
                }

                if(flag==1)
                {
                    data.execSQL("insert into userinfo values ('"+s1+"','"+s2+"','"+s4+"','"+s5+"','"+s6+"')");
                    Toast.makeText(sign.this,"DataBase Build", Toast.LENGTH_SHORT).show();
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(sign.this,login.class);
                startActivity(b);
            }
        });
    }
}
