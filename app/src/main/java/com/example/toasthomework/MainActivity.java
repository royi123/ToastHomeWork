package com.example.toasthomework;

import android.os.Bundle;
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
    public int attempts;
    public int randNum;
    public int input;
    public TextView attemptsText;
    public EditText Uinput;
    public TextView msg;
    public boolean checkAns(int n){
        if (n==randNum){
            return true;
        }
        if (n+1==randNum){
            Toast oneAway=Toast.makeText(this,"a random nuber between 1 and 9 has been generated",Toast.LENGTH_LONG);
            oneAway.show();
        }
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
        msg=(TextView) findViewById(R.id.msg);
        attemptsText=(TextView) findViewById(R.id.attempCount);
        Uinput=(EditText) findViewById(R.id.UserInput);
        Random rand=new Random();
        randNum=rand.nextInt(9-1+1)+1;
        attempts=3;
        attemptsText.setText("attempts: "+attempts);
        Toast created=Toast.makeText(this,"a random nuber between 1 and 9 has been generated",Toast.LENGTH_LONG);
        created.show();
        String str =Uinput.getText().toString();
        input=Integer.parseInt(str);


        

    }
}