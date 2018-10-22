package com.example.administrator.myapplication.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.home.HomeFragment;
import com.example.administrator.myapplication.personCenter.PersonCenterFragment;
import com.example.administrator.myapplication.square.SquareFragment;

public class FragmentAdapter {
    private FragmentManager fm;
    private HomeFragment homeFragment;
    private SquareFragment squareFragment;
    private PersonCenterFragment personCenterFragment;

    public FragmentAdapter(FragmentManager fm){
        this.fm = fm;
        FragmentTransaction ft = fm.beginTransaction();
        homeFragment = HomeFragment.newInstance();
        ft.add(R.id.fragment_content,homeFragment).commit();
    }

    public void switchTab(int index){
        hideAllFragment();
        FragmentTransaction ft = fm.beginTransaction();
        switch(index){
            case 0:
                if(homeFragment == null){
                    homeFragment = HomeFragment.newInstance();
                    ft.add(R.id.fragment_content, homeFragment);
                }
                else ft.show(homeFragment);
                break;
            case 1:
                if(squareFragment == null){
                    squareFragment = SquareFragment.newInstance();
                    ft.add(R.id.fragment_content, squareFragment);
                }
                else ft.show(squareFragment);
                break;
            case 2:
                if(personCenterFragment == null){
                    personCenterFragment = new PersonCenterFragment();
                    ft.add(R.id.fragment_content, personCenterFragment);
                }
                else ft.show(personCenterFragment);
                break;
        }
        ft.commit();
    }

    private void hideAllFragment() {
        FragmentTransaction ft = fm.beginTransaction();
        if(homeFragment != null)
            ft.hide(homeFragment);
        if(squareFragment != null)
            ft.hide(squareFragment);
        if(personCenterFragment != null)
            ft.hide(personCenterFragment);
        ft.commit();
    }
}
