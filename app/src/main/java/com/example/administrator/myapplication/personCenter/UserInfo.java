package com.example.administrator.myapplication.personCenter;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;

public class UserInfo extends AppCompatActivity {
    private ImageView avatar;
    private RelativeLayout avatar_layout, name_layout, email_layout,
            city_layout, address_layout, phone_layout, money_layout, authentication_layout;
    private ArrayList<RelativeLayout> layouts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        avatar = findViewById(R.id.user_avatar);
        avatar_layout = findViewById(R.id.user_avatar_layout);
        avatar_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 1);
            }
        });
        name_layout = findViewById(R.id.user_name_layout);
        email_layout = findViewById(R.id.user_email_layout);
        city_layout = findViewById(R.id.user_city_layout);
        address_layout = findViewById(R.id.user_address_layout);
        phone_layout = findViewById(R.id.user_phone_layout);
        money_layout = findViewById(R.id.user_money_layout);
        authentication_layout = findViewById(R.id.user_authentication_layout);
        layouts.add(name_layout);
        layouts.add(email_layout);
        layouts.add(city_layout);
        layouts.add(address_layout);
        layouts.add(phone_layout);
        layouts.add(money_layout);
        for(final RelativeLayout layout:layouts){
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changeInfo(layout.getId());
                }
            });
        }
        authentication_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //此处写实名认证点击的相应
            }
        });
    }

    public void back(View view) {
        finish();
    }

    //从手机中获取头像，并显示
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
            //获取返回的数据，这里是android自定义的Uri地址
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            //获取选择照片的数据视图
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            //从数据视图中获取已选择图片的路径
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            //将图片显示到界面上
            avatar.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }

    public void changeInfo(final int id) {
        View view = getLayoutInflater().inflate(R.layout.dialog_layout,null);
        final EditText editText = view.findViewById(R.id.et_content);
        editText.setBackgroundColor(Color.rgb(245,245,245));
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("修改信息")
                .setView(view)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TextView textView = null;
                        switch (id){
                            case R.id.user_name_layout:
                                textView = findViewById(R.id.user_name);
                                break;
                            case R.id.user_email_layout:
                                textView = findViewById(R.id.user_email);
                                break;
                            case R.id.user_city_layout:
                                textView = findViewById(R.id.user_city);
                                break;
                            case R.id.user_address_layout:
                                textView = findViewById(R.id.user_address);
                                break;
                            case R.id.user_phone_layout:
                                textView = findViewById(R.id.user_phone);
                                break;
                            case R.id.user_money_layout:
                                textView = findViewById(R.id.user_money);
                                break;
                        }
                        if(textView != null)
                            textView.setText(editText.getText().toString());
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).create();
        alertDialog.show();
    }
}
