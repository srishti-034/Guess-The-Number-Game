package com.example.srishti.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

int actualNumber;
    public void generateRandomNumber()
    {
        Random rand = new Random();
        actualNumber = rand.nextInt(30) + 1;
    }
    public void guessNumber(View v)
    {
        EditText ed = findViewById(R.id.editTextNumber);
        String msg;
        if(ed.getText().toString().isEmpty())
        {
           msg = "Please enter a number";
        }
        else
        {
            int guessedNumber = Integer.parseInt(ed.getText().toString());

            if(guessedNumber < actualNumber)
                msg = "Try to guess higher!";
            else if(guessedNumber > actualNumber)
                msg = "Try to guess lower!";
            else {
                msg = "Congrats! you guessed right....play again";
                generateRandomNumber();
            }

        }

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       generateRandomNumber();
    }
}
