package com.example.administrator.myapplication.square;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.home.ProgramInfo;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProductListFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    private ArrayList<JSONObject> datas = new ArrayList<>();

    public UserProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_product_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        MyRecycleViewAdapter myRecycleViewAdapter =
                new MyRecycleViewAdapter(R.layout.user_product_item,datas);
        recyclerView.addItemDecoration(new SpaceItemDecoration(20));
        recyclerView.setAdapter(myRecycleViewAdapter);
        refreshLayout = view.findViewById(R.id.refreshLayout);
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

            }
        });

        myRecycleViewAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if(view.getId() == R.id.user_program){
                    Intent intent = new Intent(view.getContext(), ProgramInfo.class);
                    startActivity(intent);
                }else if(view.getId() == R.id.buy){
                    View v = getLayoutInflater().inflate(R.layout.dialog_layout,null);
                    final EditText editText = v.findViewById(R.id.et_content);
                    editText.setHint("请输入密码");
                    editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    AlertDialog alertDialog = new AlertDialog.Builder(view.getContext())
                            .setTitle("输入密码")
                            .setView(v)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    System.out.println(editText.getText());
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).create();
                    alertDialog.show();
                }
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
            helper.addOnClickListener(R.id.user_program)
                .addOnClickListener(R.id.buy);
        }
    }

    class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace;

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildAdapterPosition(view) != 0) {
                outRect.top = mSpace;
            }
        }

        SpaceItemDecoration(int space) {
            this.mSpace = space;
        }
    }
}
