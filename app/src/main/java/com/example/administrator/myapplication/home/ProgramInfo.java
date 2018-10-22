package com.example.administrator.myapplication.home;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;


public class ProgramInfo extends AppCompatActivity {
    private String[] titles = {"项目介绍","团队介绍", "评论"};
    private ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private CollapsingToolbarLayout cToolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        viewPager = findViewById(R.id.id_viewpager);
        tabLayout = findViewById(R.id.id_tabLayout);
        fragmentsList.add(new ProgramInfoPage1());
        fragmentsList.add(new ProgramInfoPage2());
        fragmentsList.add(new ProgramInfoPage3());
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.colorPrimary));
        tabLayout.setupWithViewPager(viewPager);
        cToolbar = findViewById(R.id.collapsing_toolbar_layout);
        cToolbar.setTitleEnabled(false);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.enter_left);
        toolbar.setTitle("项目详情");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        imageView = findViewById(R.id.product_image);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentsList.get(position);
        }


        @Override
        public int getCount() {
            return fragmentsList.size();
        }

        //这里设置的是tablayout的title标题内容
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

    }

    void back(){
        finish();
    }

    public void back(View view){
        finish();
    }
}
