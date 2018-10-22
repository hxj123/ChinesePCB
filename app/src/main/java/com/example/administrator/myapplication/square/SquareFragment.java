package com.example.administrator.myapplication.square;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.home.Search;

import java.util.ArrayList;

public class SquareFragment extends Fragment {
    private static SquareFragment fragment = null;
    private String[] titles = {"产品","文章"};
    private View view;
    private ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @SuppressLint("ValidFragment")
    private SquareFragment() {
    }

    public static SquareFragment newInstance() {
        if(fragment==null)
            fragment = new SquareFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_squre, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager = view.findViewById(R.id.id_viewpager);
        tabLayout = view.findViewById(R.id.id_tabLayout);
        fragmentsList.add(new UserProductListFragment());
        fragmentsList.add(new ArticleListFragment());
        MyPagerAdapter adapter = new MyPagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        tabLayout.setupWithViewPager(viewPager);
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

    public void toSearch(View view){
        Intent intent=new Intent(view.getContext(), Search.class);
        startActivity(intent);
    }

}
