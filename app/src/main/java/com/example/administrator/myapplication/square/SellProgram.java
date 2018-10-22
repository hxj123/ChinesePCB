package com.example.administrator.myapplication.square;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.myapplication.R;

public class SellProgram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_program);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }

    public void back(View view){
        finish();
    }

    public void submit(View view){
        finish();
    }
}
