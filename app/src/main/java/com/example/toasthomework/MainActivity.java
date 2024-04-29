package com.example.toasthomework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public Button submit;
    public int attempts;
    public int randNum;
    public int input;
    public TextView attemptsText;
    public EditText Uinput;
    public TextView msg;
    public boolean checkAns(int n){
        boolean bool =false;
        if (n==randNum){
            bool=true;
        }
        if (n>randNum){
            Toast tooBig=Toast.makeText(this,"your number is too big",Toast.LENGTH_LONG);
            tooBig.show();
            bool=false;
        }
        if (n<randNum){
            Toast tooSmall=Toast.makeText(this,"your number is too small",Toast.LENGTH_LONG);
            tooSmall.show();
            bool=false;
        }
        return bool;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        submit=(Button) findViewById(R.id.Submit);
        msg=(TextView) findViewById(R.id.msg);
        attemptsText=(TextView) findViewById(R.id.attempCount);
        Uinput=(EditText) findViewById(R.id.UserInput);
        Random rand=new Random();
        randNum=rand.nextInt(9-1+1)+1;
        attempts=3;
        attemptsText.setText("attempts: "+attempts);
        Toast created=Toast.makeText(this,"a random nuber between 1 and 9 has been generated",Toast.LENGTH_LONG);
        created.show();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =Uinput.getText().toString();
                input=Integer.parseInt(str);
                if (checkAns(input)==true){
                    msg.setText("You Won :D");

                }
                if (checkAns(input)==false){
                    attempts--;
                    attemptsText.setText("attempts: "+attempts);
                }
            }
        });



        

    }
}