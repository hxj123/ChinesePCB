package com.example.administrator.myapplication.home;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.myapplication.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProgramList extends Activity {
    private TextView title;
    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    private ArrayList<JSONObject> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pragram_list);

        Intent intent = getIntent();
        title = findViewById(R.id.tv_title);
        title.setText(intent.getStringExtra("title"));
        if(intent.getStringExtra("content")!=null){

        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL));
        MyRecycleViewAdapter myRecycleViewAdapter =
                new MyRecycleViewAdapter(R.layout.program_item,datas);
        recyclerView.setAdapter(myRecycleViewAdapter);
        refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });

        myRecycleViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(view.getContext(), ProgramInfo.class);
                startActivity(intent);
            }
        });

        datas.add(new JSONObject());
        datas.add(new JSONObject());
        datas.add(new JSONObject());
        datas.add(new JSONObject());
        datas.add(new JSONObject());
        datas.add(new JSONObject());
        datas.add(new JSONObject());
        datas.add(new JSONObject());
    }

    class MyRecycleViewAdapter extends BaseQuickAdapter<JSONObject, BaseViewHolder> {
        MyRecycleViewAdapter(int layoutResId, List data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, JSONObject item) {

        }
    }

    public void back(View view){
        finish();
    }
}
