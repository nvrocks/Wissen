package com.quiz.mnnit.wissen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView question,textScore;
    ToggleButton opt1,opt2,opt3,opt4;
    Question currentQues;
    Button submit;
    int score=0;
    List<Question> quesList;
    String op1,correctAns,op2,op3,op4,ques;
    String selectedAns;
    int qid=0;
    int c1=0,c2=0;
   // int RED=-65536;
   int cd=R.color.wrongAns;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question=(TextView)findViewById(R.id.questionView);
        opt1=(ToggleButton)findViewById(R.id.opt1);
        opt2=(ToggleButton)findViewById(R.id.opt2);
        opt3=(ToggleButton)findViewById(R.id.opt3);
        opt4=(ToggleButton)findViewById(R.id.opt4);
        textScore=(TextView)findViewById(R.id.textScore);
        submit=(Button)findViewById(R.id.submitBut);
        score=0;
        Typeface font=Typeface.createFromAsset(getAssets(),"fontawesome-webfont.ttf");
        question.setTypeface(font);
       // Typeface font=Typeface.createFromAsset(getAssets(),"fontawesome-webfont.ttf");
        //question.setTypeface(font);
        //Typeface scfont=Typeface.createFromAsset(getAssets(),"DIGITALDREAMNARROW.ttf");
        //question.setTypeface(scfont);
        String cat = getIntent().getStringExtra("cat");
        quesList=new ArrayList<Question>();
        String ur="https://www.opentdb.com/api.php?amount=10&category="+cat+"&type=multiple";
        new QuestionAsynTask().execute(ur);

        //buttonOnCreate();
        submit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,correctAns+" selected "+selectedAns,Toast.LENGTH_SHORT).show();

                opt1.setClickable(false);
                opt2.setClickable(false);
                opt3.setClickable(false);
                opt4.setClickable(false);
                    if (correctAns.equals(selectedAns)) {
                        Toast.makeText(MainActivity.this, "Conrrect Answer....!!!!", Toast.LENGTH_SHORT).show();
                        //currentQues=quesList.get(qid);
                        score += 10;
                        textScore.setText(score + "");
                        if (opt1.getText().equals(correctAns))
                            opt1.setBackgroundColor(Color.GREEN);
                        else if (opt2.getText().equals(correctAns))
                            opt2.setBackgroundColor(Color.GREEN);
                        else if (opt3.getText().equals(correctAns))
                            opt3.setBackgroundColor(Color.GREEN);
                        else
                            opt4.setBackgroundColor(Color.GREEN);

                        new CountDownTimer(2000, 50) {

                            @Override
                            public void onTick(long arg0) {
                                // TODO Auto-generated method stub

                            }

                            @Override
                            public void onFinish() {
                                opt1.setClickable(true);
                                opt2.setClickable(true);
                                opt3.setClickable(true);
                                opt4.setClickable(true);
                                opt1.setBackgroundResource(R.drawable.button);
                                opt2.setBackgroundResource(R.drawable.button);
                                opt3.setBackgroundResource(R.drawable.button);
                                opt4.setBackgroundResource(R.drawable.button);
                                buttonOnCreate();
                            }
                        }.start();

                        // buttonOnCreate();
                    } else {
                        //opt1.setBackgroundColor(getResources().getColor(R.color.wrongAns));
                        Toast.makeText(MainActivity.this, "Wrong Answer :-(", Toast.LENGTH_SHORT).show();
                        score -= 5;
                        textScore.setText(score + "");
                        //opt1.setBackgroundColor(Color.RED);
                        if (opt1.getText().equals(selectedAns))
                            opt1.setBackgroundColor(Color.RED);
                        else if (opt2.getText().equals(selectedAns))
                            opt2.setBackgroundColor(Color.RED);
                        else if (opt3.getText().equals(selectedAns))
                            opt3.setBackgroundColor(Color.RED);
                        else
                            opt4.setBackgroundColor(Color.RED);


                        if (opt1.getText().equals(correctAns))
                            opt1.setBackgroundColor(Color.GREEN);
                        else if (opt2.getText().equals(correctAns))
                            opt2.setBackgroundColor(Color.GREEN);
                        else if (opt3.getText().equals(correctAns))
                            opt3.setBackgroundColor(Color.GREEN);
                        else
                            opt4.setBackgroundColor(Color.GREEN);

                        new CountDownTimer(2000, 50) {

                            @Override
                            public void onTick(long arg0) {
                                // TODO Auto-generated method stub

                            }

                            @Override
                            public void onFinish() {
                                opt1.setClickable(true);
                                opt2.setClickable(true);
                                opt3.setClickable(true);
                                opt4.setClickable(true);
                                opt1.setBackgroundResource(R.drawable.button);
                                opt2.setBackgroundResource(R.drawable.button);
                                opt3.setBackgroundResource(R.drawable.button);
                                opt4.setBackgroundResource(R.drawable.button);
                                buttonOnCreate();
                            }
                        }.start();

                    /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //dismiss the dialog
                                    buttonOnCreate();
                                }
                            });
                    builder.setMessage(" WRONG ANSWER");
                    builder.setTitle("MESSAGE");
                    AlertDialog dialog=builder.create();*/
                        //currentQues=quesList.get(qid);

                    }


            }
        });

    }

    public void buttonOnCreate()
    {

        if(qid==10)
        {
            Intent intent=new Intent(MainActivity.this,Score.class);
            intent.putExtra("score",score+"");
            startActivity(intent);
        }
        else {
            Random rand = new Random();

            //qid=rand.nextInt(10000)%50;
            /*QuizHelper db=new QuizHelper(this);
            quesList=db.getAllQuestions();*/
            currentQues = quesList.get(qid);
            ques = currentQues.getQUESTION();
            correctAns = currentQues.getANSWER();
            String temp = "Question " + (qid + 1) + " of 10:<br>";
            ques = temp + ques;
            question.setText(Html.fromHtml(ques));
            String[] optArr = new String[4];
            optArr[0] = currentQues.getOPTA();
            optArr[1] = currentQues.getOPTB();
            optArr[2] = currentQues.getOPTC();
            optArr[3] = currentQues.getANSWER();

            int i1 = rand.nextInt(10000) % 4;
            int i2, i3, i4;
            while (true) {
                i2 = rand.nextInt(10000) % 4;
                if (i2 != i1)
                    break;
            }
            while (true) {
                i3 = rand.nextInt(10000) % 4;
                if (i3 != i1 && i3 != i2)
                    break;
            }
            while (true) {
                i4 = rand.nextInt(10000) % 4;
                if (i4 != i1 && i4 != i2 && i4 != i3)
                    break;
            }
            op1 = optArr[i1];
            op2 = optArr[i2];
            op3 = optArr[i3];
            op4 = optArr[i4];
            opt1.setText(op1);
            opt2.setText(op2);
            opt3.setText(op3);
            opt4.setText(op4);
            opt1.setTextOn(op1);
            opt1.setTextOff(op1);
            opt2.setTextOn(op2);
            opt2.setTextOff(op2);
            opt3.setTextOn(op3);
            opt3.setTextOff(op3);
            opt4.setTextOn(op4);
            opt4.setTextOff(op4);
            opt1.setChecked(false);
            opt2.setChecked(false);
            opt3.setChecked(false);
            opt4.setChecked(false);
            opt1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (opt1.isChecked()) {
                        // The toggle is enabled
                        selectedAns = (String) opt1.getText();
                        //Toast.makeText(MainActivity.this,"A selected",Toast.LENGTH_SHORT).show();
                        opt2.setChecked(false);
                        opt3.setChecked(false);
                        opt4.setChecked(false);
                    }
                }
            });
            opt2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (opt2.isChecked()) {
                        // The toggle is enabled
                        selectedAns = (String) opt2.getText();
                        ;
                        //Toast.makeText(MainActivity.this,"B selected",Toast.LENGTH_SHORT).show();
                        opt1.setChecked(false);
                        opt3.setChecked(false);
                        opt4.setChecked(false);
                    }
                }
            });
            opt3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (opt3.isChecked()) {
                        // The toggle is enabled
                        selectedAns = (String) opt3.getText();
                        ;
                        //Toast.makeText(MainActivity.this,"C selected",Toast.LENGTH_SHORT).show();
                        opt2.setChecked(false);
                        opt1.setChecked(false);
                        opt4.setChecked(false);
                    }
                }
            });
            opt4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (opt4.isChecked()) {
                        // The toggle is enabled
                        selectedAns = (String) opt4.getText();
                        ;
                        //Toast.makeText(MainActivity.this,"D selected",Toast.LENGTH_SHORT).show();
                        opt2.setChecked(false);
                        opt3.setChecked(false);
                        opt1.setChecked(false);
                    }
                }
            });
            qid++;
        }
    }
    public class QuestionAsynTask extends AsyncTask<String, Void,Boolean>
    {

        @Override
        protected Boolean doInBackground(String... params) {

            try {
                //Toast.makeText(MainActivity.this,"try",Toast.LENGTH_SHORT).show();
                //System.out.println("try status");
                //c1=1;
                URL url=new URL(params[0]);
                //c1=1;
                HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                //conn.setConnectTimeout();
                int status=conn.getResponseCode();
                //c2=1;
                //System.out.println(status+" status");
                //c2=status;
                if (status==HttpURLConnection.HTTP_OK) {
                    InputStream is=conn.getInputStream();
                    BufferedReader br=new BufferedReader(new InputStreamReader(is));
                    String data="",line;
                    while((line=br.readLine())!=null)
                    {
                        data+=line;
                    }
                    Log.d("abc",data+"");
                    JSONObject jsono = new JSONObject(data);
                    JSONArray jarray = jsono.getJSONArray("results");

                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);

                        Question ques = new Question();
                        ques.setCATEGORY(object.getString("category"));
                        ques.setTYPE(object.getString("type"));
                        ques.setDIFFICULTY(object.getString("difficulty"));
                        ques.setQUESTION(object.getString("question"));
                        ques.setANSWER(object.getString("correct_answer"));
                        JSONArray jarray1 = object.getJSONArray("incorrect_answers");
                        ques.setOPTA(jarray1.getString(0));
                        ques.setOPTB(jarray1.getString(1));
                        ques.setOPTC(jarray1.getString(2));
                        quesList.add(ques);
                    }
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (result == false) {
                Toast.makeText(MainActivity.this, c1 + "False" + c2, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "True", Toast.LENGTH_SHORT).show();
                long seed = System.nanoTime();
                Collections.shuffle(quesList, new Random(seed));
                buttonOnCreate();
            }
        }


    }

}
