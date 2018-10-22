package com.example.administrator.myapplication.personCenter;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.home.MyProgramList;


public class PersonCenterFragment extends Fragment {
    private static PersonCenterFragment fragment = null;
    private RelativeLayout userInfolLayout,myProgram,myProduct,myHistory,myMessage;
    private View view;

    @SuppressLint("ValidFragment")
    public PersonCenterFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_person_center, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        userInfolLayout = view.findViewById(R.id.user_info_layout);
        userInfolLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), UserInfo.class);
                startActivity(intent);
            }
        });

        myProgram = view.findViewById(R.id.my_program);
        myProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), MyProgramList.class);
                startActivity(intent);
            }
        });
        myProduct = view.findViewById(R.id.my_product);
        myHistory = view.findViewById(R.id.my_history);
        myMessage = view.findViewById(R.id.my_message);
    }
}
