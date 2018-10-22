package com.example.administrator.myapplication.personCenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ExchangeService extends AppCompatActivity {
    private TextView textView;
    private String itemId;
    private String goodId,userId;
    private Handler handler = new Handler();
    private EditText benefit_people,identity,time,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        itemId = getIntent().getStringExtra("itemId");
        goodId = getIntent().getStringExtra("goodId");
        userId = getIntent().getStringExtra("userId");
        setContentView(R.layout.activity_exchange_service);
        textView = findViewById(R.id.item_limited);
        textView.setText("本项目旨在替有独立思想的中老年规划今后的集体群居生活，和直接进去养老院不同，我们的目的是按照客户的想法，规划和设计适合他们的心里想的养老方式，让让各位享受随心所欲的养老生活！\n\n" +
                "为人数小于5的客户规划未来养老方案\n\n" +
                "允许兑换日期2023.04.08-00:00:00\n\n" +
                "年龄大小不定");

        benefit_people = findViewById(R.id.benefit_people);
        identity = findViewById(R.id.identity);
        address = findViewById(R.id.address);
    }

    public void submit(View view){
        final String benefitPeople = benefit_people.getText().toString();
        final String peopleIdentity = identity.getText().toString();
        final String exchangeTime = time.getText().toString();
        final String exchangeAddress = address.getText().toString();
        if(benefitPeople.length() == 0 ||
                peopleIdentity.length() == 0 ||
                exchangeTime.length() == 0 ||
                exchangeAddress.length() == 0){
            Toast.makeText(getApplication(), "请填写完整信息", Toast.LENGTH_SHORT).show();
            return;
        }
    }


    public void back(View view){
        Intent intent = new Intent();
        intent.putExtra("result",true);
        setResult(1,intent);
        finish();
    }
}