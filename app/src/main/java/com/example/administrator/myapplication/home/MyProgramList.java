package com.example.administrator.myapplication.home;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.personCenter.ExchangeService;
import com.example.administrator.myapplication.personCenter.ItemReview;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyProgramList extends AppCompatActivity {
    private String[] labels = new String[]
            {"全部", "筹集中", "建设中", "可兑换", "已兑换", "失败"};
    private TagFlowLayout flowLayout;
    private RecyclerView recyclerView;
    private ArrayList<MultipleItem> datas = new ArrayList<>(),
            allItems = new ArrayList<>();
    private MyRecycleViewAdapter myRecycleViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LayoutInflater mInflater = LayoutInflater.from(this);
        setContentView(R.layout.activity_my_program_list);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        flowLayout = findViewById(R.id.flow_layout);
        flowLayout.setAdapter(new TagAdapter<String>(labels) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.label_text,
                        flowLayout, false);
                tv.setText(s);
                return tv;
            }

            @Override
            public boolean setSelected(int position, String s) {
                return s.equals("全部");
            }
        });
        flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, com.zhy.view.flowlayout.FlowLayout parent) {
                datas.clear();
                System.out.println(allItems);
                for(MultipleItem item: allItems) {
                    if (position == item.getItemType() + 1) {
                        datas.add(item);
                    }
                }
                if(position == 0){
                    datas.addAll(allItems);
                }
                myRecycleViewAdapter.notifyDataSetChanged();
                return true;
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecycleViewAdapter = new MyRecycleViewAdapter(datas);
        recyclerView.addItemDecoration(new SpaceItemDecoration(20));
        recyclerView.setAdapter(myRecycleViewAdapter);
        myRecycleViewAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MyProgramList.this, ProgramInfo.class);
                intent.putExtra("itemId","");
                startActivity(intent);
            }
        });

        myRecycleViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MyProgramList.this, ProgramInfo.class);
                startActivity(intent);
            }
        });

        myRecycleViewAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if(view.getId() == R.id.tv_exchange){
                    Intent intent = new Intent(MyProgramList.this, ExchangeService.class);
                    startActivity(intent);
                }else if(view.getId() == R.id.tv_sell){
                    Intent intent = new Intent(MyProgramList.this, ItemReview.class);
                    startActivity(intent);
                }else if(view.getId() == R.id.tv_review){
                    Intent intent = new Intent(MyProgramList.this, ItemReview.class);
                    startActivity(intent);
                }
            }
        });

        datas.add(new MultipleItem(MultipleItem.RAISING,new JSONObject()));
        datas.add(new MultipleItem(MultipleItem.BUILDING,new JSONObject()));
        datas.add(new MultipleItem(MultipleItem.CANEXCHANGE,new JSONObject()));
        datas.add(new MultipleItem(MultipleItem.EXCHANGED,new JSONObject()));
        datas.add(new MultipleItem(MultipleItem.FAIL,new JSONObject()));
        datas.add(new MultipleItem(MultipleItem.RAISING,new JSONObject()));
        datas.add(new MultipleItem(MultipleItem.BUILDING,new JSONObject()));
        datas.add(new MultipleItem(MultipleItem.CANEXCHANGE,new JSONObject()));
        datas.add(new MultipleItem(MultipleItem.EXCHANGED,new JSONObject()));
        datas.add(new MultipleItem(MultipleItem.FAIL,new JSONObject()));
        allItems = new ArrayList<>(datas);
        myRecycleViewAdapter.notifyDataSetChanged();
    }

    public class MultipleItem implements MultiItemEntity {
        public static final int RAISING = 0;
        public static final int BUILDING = 1;
        public static final int CANEXCHANGE = 2;
        public static final int EXCHANGED = 3;
        public static final int FAIL = 4;
        private int itemType;
        private JSONObject object;

        public MultipleItem(int itemType, JSONObject object) {
            this.itemType = itemType;
            this.object = object;
        }

        @Override
        public int getItemType() {
            return itemType;
        }

        public JSONObject getJSONObject() {
            return object;
        }
    }

    public void back(View view){
        finish();
    }

    class MyRecycleViewAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
        MyRecycleViewAdapter(List<MultipleItem> data) {
            super(data);
            addItemType(MultipleItem.RAISING, R.layout.raising_item);
            addItemType(MultipleItem.BUILDING, R.layout.building_item);
            addItemType(MultipleItem.CANEXCHANGE, R.layout.can_exchange_item);
            addItemType(MultipleItem.EXCHANGED, R.layout.exchanged_item);
            addItemType(MultipleItem.FAIL, R.layout.fail_item);
        }

        @Override
        protected void convert(BaseViewHolder helper, MultipleItem item) {
            if(item.getItemType() == MultipleItem.CANEXCHANGE){
                helper.addOnClickListener(R.id.tv_exchange);
                helper.addOnClickListener(R.id.tv_sell);
            }else if(item.getItemType() == MultipleItem.EXCHANGED){
                helper.addOnClickListener(R.id.tv_review);
            }
        }
    }

    class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace;

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
                outRect.top = mSpace;
        }

        SpaceItemDecoration(int space) {
            this.mSpace = space;
        }
    }
}
