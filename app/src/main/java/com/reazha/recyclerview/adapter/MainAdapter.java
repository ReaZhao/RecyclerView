package com.reazha.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reazha.recyclerview.R;

import java.util.ArrayList;

/**
 * @author ReaZhao
 * @date 2016/12/9
 * @FileName MainAdapter
 * @E-mail 377742053qq.com
 * @desc 类的说明介绍
 */

public class MainAdapter extends RecyclerView.Adapter<ViewHolderRecycler> {
    private Context context;
    private ArrayList<String> mDatas = new ArrayList<>();

    public MainAdapter(Context context, ArrayList<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    /**
     * 创建ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolderRecycler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item, parent,
                false);
        ViewHolderRecycler holder = new ViewHolderRecycler(itemView);

        return holder;
    }

    /**
     * 将数据绑定至ViewHolder
     *
     * @param vhr
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolderRecycler vhr, int position) {
        try {
            TextView textView =  vhr.getView(R.id.id_num);
            textView.setText(mDatas.get(position));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取总的条目数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
