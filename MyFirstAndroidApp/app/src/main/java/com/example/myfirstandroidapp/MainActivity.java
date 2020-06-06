package com.example.myfirstandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import android.content.Context;
import android .content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   private Button btnStart;
   private Button btnStartAgain;
   private Button btnExit;
   private TextView txtMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) this.findViewById(R.id.btnStart);
        btnStartAgain = (Button) this.findViewById(R.id.btnStartAgain);
        btnExit = (Button) this.findViewById(R.id.btnExit);
        txtMessage = (TextView) this.findViewById(R.id.txtMessage);

        btnStart.setOnClickListener(this);
        btnStartAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnStartAgain.setVisibility(View.GONE);
        btnExit.setVisibility(View.GONE);
    }

    public void onClick(View v){
        final EditText input = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("What do you want to talk about? ")
                .setView(input)
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        keepTalking(input.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
        startAgain();

    }

    public void keepTalking(final String t){
        AlertDialog secondDialog = new AlertDialog.Builder(this)
        .setMessage("Do you like " + t + "?")
        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                likeTopic(t);
            }
        })
        .setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dailog, int which){
                dislikeTopic(t);
            }
        })
        .show();
    }

    public void likeTopic(String t){
        Context context = getApplicationContext();
        CharSequence message = "I like " + t + " too!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    public void dislikeTopic(String t){
        Context context = getApplicationContext();
        CharSequence message = "I hate " + t + " too.";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    public void startAgain(){
        btnStart.setVisibility(View.GONE);
        txtMessage.setVisibility(View.GONE);
        btnStartAgain.setVisibility(View.VISIBLE);
        btnExit.setVisibility(View.VISIBLE);
    }
}
