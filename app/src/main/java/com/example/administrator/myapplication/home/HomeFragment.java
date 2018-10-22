package com.example.administrator.myapplication.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.square.ArticleInfo;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private static HomeFragment fragment = null;
    private RelativeLayout type1,type2,type3,type4,article1,article2,article3,article4;
    private View view;
    private TextView tvSearch;

    @SuppressLint("ValidFragment")
    private HomeFragment() {
    }

    public static HomeFragment newInstance() {
        if(fragment==null)
            fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvSearch = view.findViewById(R.id.tv_search);
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Search.class);
                startActivity(intent);
            }
        });

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.a);
        images.add(R.drawable.b);
        images.add(R.drawable.c);
        images.add(R.drawable.d);
        Banner banner = view.findViewById(R.id.banner);
        banner.setImages(images).setImageLoader(new GlideImageLoader());
        banner.setDelayTime(4000);
        banner.start();

        type1 = view.findViewById(R.id.rl_type1);
        type1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ProgramList.class);
                intent.putExtra("title","生态养老");
                startActivity(intent);
            }
        });
        type2 = view.findViewById(R.id.rl_type2);
        type2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ProgramList.class);
                intent.putExtra("title","保健产品");
                startActivity(intent);
            }
        });
        type3 = view.findViewById(R.id.rl_type3);
        type3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ProgramList.class);
                intent.putExtra("title","医疗保健");
                startActivity(intent);
            }
        });
        type4 = view.findViewById(R.id.rl_type4);
        type4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ProgramList.class);
                intent.putExtra("title","养老代理");
                startActivity(intent);
            }
        });

        article1 = view.findViewById(R.id.article1);
        article1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ArticleInfo.class);
                startActivity(intent);
            }
        });
        article2 = view.findViewById(R.id.article2);
        article2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ArticleInfo.class);
                startActivity(intent);
            }
        });
        article3 = view.findViewById(R.id.article3);
        article3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ArticleInfo.class);
                startActivity(intent);
            }
        });
        article4 = view.findViewById(R.id.article4);
        article4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ArticleInfo.class);
                startActivity(intent);
            }
        });
    }

    class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
