package com.example.administrator.myapplication.home;


import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
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
public class ProgramInfoPage2 extends Fragment {
    private RecyclerView otherProgram;
    private View view;
    private ArrayList<JSONObject> datas = new ArrayList<>();

    public ProgramInfoPage2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_program_info_page2, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        otherProgram = view.findViewById(R.id.other_program_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        otherProgram.setLayoutManager(linearLayoutManager);
        otherProgram.addItemDecoration(new SpaceItemDecoration(15));
        MyRecycleViewAdapter myRecycleViewAdapter =
                new MyRecycleViewAdapter(R.layout.other_program_item,datas);
        otherProgram.setAdapter(myRecycleViewAdapter);

        for(int i = 1;i <= 8;i++) {
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
                Glide.with(view.getContext()).load(item.getString("imgURL")).into((ImageView) helper.getView(R.id.other_program_img));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace;

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildAdapterPosition(view) != 0) {
                outRect.left = mSpace;
            }
        }

        SpaceItemDecoration(int space) {
            this.mSpace = space;
        }
    }
}
