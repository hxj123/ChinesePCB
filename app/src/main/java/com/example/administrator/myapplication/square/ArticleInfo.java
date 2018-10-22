package com.example.administrator.myapplication.square;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

public class ArticleInfo extends AppCompatActivity {
    private TextView artcle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_info);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        artcle = findViewById(R.id.article_text);
        artcle.setText("医养结合是近几年逐渐兴起于各地的一种新型养老模式。由于其将现代医疗服务技术与养老保障模式有效结合，实现了“有病治病、无病疗养”的养老保障模式创新，已经成为政府决策部门及学者们共同关注的热点问题。\n\n" +
                "从内涵上来讲，医养结合具有以下基本特点：从保障目的来看，与传统养老模式一样，医养结合旨在为老年人提供老年生活服务，以使老人安度晚年。\n\n" +
                "从参与主体来看，它联合传统养老机构与医疗机构，旨在通过多元化的参与主体，为老年人提供一种新型的养老服务。\n\n" +
                "从服务内容来看，由于引入了现代医疗技术，它能够提供更加专业、便捷的养老服务，有效提高老年人的晚年生活质量。\n\n" +
        "从保障对象来看，尤其适宜处于大病康复期、慢性病、易复发病患者等无法在传统养老模式中得到良好照料的失能、半失能老人；\n\n" +
                "从人性角度来看，它同时考虑了老年人的养老需求与医疗需求，符合现代老年人“医养共需”的基本生活需求。\n\n" +
                "从广义范畴来界定，医养结合不仅是将传统养老保障与现代医疗有机结合的一种新型养老方式探索，还意味着一种跨越式的养老新理念。");
    }

    public void back(View view){
        finish();
    }
}
