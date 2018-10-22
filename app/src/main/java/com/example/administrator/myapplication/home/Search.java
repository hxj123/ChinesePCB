package com.example.administrator.myapplication.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

public class Search extends AppCompatActivity implements TextView.OnEditorActionListener {

    private EditText editSearch;
    private ImageView imageView,deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        editSearch = findViewById(R.id.edit_search);
        deleteButton= findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editSearch.setText("");
            }
        });
        editSearch.setOnEditorActionListener(this);
        editSearch.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editSearch.length()<1)
                    deleteButton.setVisibility(View.GONE);
                else deleteButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        imageView = findViewById(R.id.search_icon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSearchResult();
            }
        });
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // 当按了搜索之后关闭软键盘
            ((InputMethodManager) editSearch.getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    Search.this.getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
            toSearchResult();
            return true;
        }
        return false;
    }

    private void toSearchResult(){
        String content = editSearch.getText().toString();
        if(editSearch.length()==0)
            Toast.makeText(getApplication(),"请输入内容", Toast.LENGTH_SHORT).show();
        else {
            finish();
            Intent intent = new Intent(Search.this, ProgramList.class);
            intent.putExtra("title", "搜索结果");
            intent.putExtra("content", content);
            startActivity(intent);
        }
    }
}
