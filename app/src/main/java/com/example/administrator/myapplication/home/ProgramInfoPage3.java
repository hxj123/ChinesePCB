package com.example.administrator.myapplication.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramInfoPage3 extends Fragment {
    private RecyclerView reviewList;
    private View view;
    private ArrayList<JSONObject> datas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_program_info_page3, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        reviewList = view.findViewById(R.id.review_list);
        reviewList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        MyRecycleViewAdapter myRecycleViewAdapter =
                new MyRecycleViewAdapter(R.layout.review_item,datas);
//        reviewList.setNestedScrollingEnabled(false);
//        reviewList.setHasFixedSize(true);
        reviewList.setAdapter(myRecycleViewAdapter);
        reviewList.addItemDecoration(new DividerItemDecoration(
                view.getContext(), DividerItemDecoration.VERTICAL));

        datas.add(new JSONObject());
        datas.add(new JSONObject());
        datas.add(new JSONObject());
        datas.add(new JSONObject());
        datas.add(new JSONObject());
        datas.add(new JSONObject());
    }

    class MyRecycleViewAdapter extends BaseQuickAdapter<JSONObject, BaseViewHolder> {
        MyRecycleViewAdapter(int layoutResId, List item) {
            super(layoutResId, item);
        }

        @Override
        protected void convert(BaseViewHolder helper, JSONObject item) {

        }
    }
}
