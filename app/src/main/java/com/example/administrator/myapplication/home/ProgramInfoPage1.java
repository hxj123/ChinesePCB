package com.example.administrator.myapplication.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
public class ProgramInfoPage1 extends Fragment {
    private View view;
    private RecyclerView detail_img;
    private ArrayList<JSONObject> datas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_program_info_page1, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        detail_img = view.findViewById(R.id.program_detail_list);
        detail_img.setLayoutManager(new LinearLayoutManager(view.getContext()));
        MyRecycleViewAdapter myRecycleViewAdapter =
                new MyRecycleViewAdapter(R.layout.program_detail_item,datas);
//        detail_img.setNestedScrollingEnabled(false);
//        detail_img.setHasFixedSize(true);
        detail_img.setAdapter(myRecycleViewAdapter);

        for(int i = 1;i <= 11;i++) {
            try {
                datas.add(new JSONObject().put("imgURL","http://cxyxh.top/huaqibei/p"+i+".jpg"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        myRecycleViewAdapter.notifyDataSetChanged();
    }

    class MyRecycleViewAdapter extends BaseQuickAdapter<JSONObject, BaseViewHolder> {
        MyRecycleViewAdapter(int layoutResId, List item) {
            super(layoutResId, item);
        }

        @Override
        protected void convert(BaseViewHolder helper, JSONObject item) {
            try {
                Glide.with(view.getContext()).load(item.getString("imgURL")).into((ImageView) helper.getView(R.id.program_detail_img));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
