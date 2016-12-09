package com.reazha.recyclerview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.reazha.recyclerview.R;
import com.reazha.recyclerview.adapter.MainAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private RecyclerView idRecyclerview;
    private ArrayList<String> mDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDada();
        initView();
    }

    /**
     * 初始化数据
     */
    private void initDada() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'Z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    /**
     * 初始化控件
     */
    private void initView() {
        idRecyclerview = (RecyclerView) findViewById(R.id.id_recyclerview);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //水平布局  和垂直布局 默认是LinearLayout.VERTICAL
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        idRecyclerview.setLayoutManager(linearLayoutManager);
        //设置适配器
        idRecyclerview.setAdapter(new MainAdapter(this, mDatas));
    }

}
