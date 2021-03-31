package com.mohit.flipcoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Selection extends AppCompatActivity {

    EditText heads_input,tails_input;
    ImageView nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        heads_input = (EditText) findViewById(R.id.head_et);
        tails_input = (EditText) findViewById(R.id.tail_et);
        nextBtn = (ImageView) findViewById(R.id.nextBtn);
    }

    public void arrowClicked(View view)
    {
        String headsStr = heads_input.getText().toString();
        String tailsStr = tails_input.getText().toString();

        if(tailsStr.isEmpty() || headsStr.isEmpty()){
            Toast.makeText(this,"Please Assign Value",Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this, TossCoin.class);
            intent.putExtra("Heads", headsStr);
            intent.putExtra("Tails", tailsStr);
            startActivity(intent);
        }
    }
}