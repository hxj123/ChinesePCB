package com.example.administrator.myapplication.personCenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemReview extends AppCompatActivity {
    private SimpleRatingBar srating;
    private AlertDialog alertDialog;
    private EditText reviewContent;
    private String itemId;
    private String userId;
    private String goodId;
    private String price;
    private SimpleRatingBar ratingBar;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_review);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        srating = findViewById(R.id.ratingbar);
        srating.setOnRatingBarChangeListener(new SimpleRatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(SimpleRatingBar simpleRatingBar, float rating, boolean fromUser) {
                if(srating.getRating() == 0) srating.setRating(1);
            }
        });
        reviewContent = findViewById(R.id.et_content);
        ratingBar = findViewById(R.id.ratingbar);
        itemId = getIntent().getStringExtra("itemId");
        goodId = getIntent().getStringExtra("goodId");
        price = getIntent().getStringExtra("price");
        userId = getIntent().getStringExtra("userId");
    }


    public void submit(View v) {

    }

    public void back(View view){
        Intent intent = new Intent();
        intent.putExtra("result",false);
        setResult(2,intent);
        finish();
    }
}