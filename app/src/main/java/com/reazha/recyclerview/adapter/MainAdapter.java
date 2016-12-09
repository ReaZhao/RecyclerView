package com.reazha.recyclerview.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onBindViewHolder(final ViewHolderRecycler vhr, final int position) {
        try {
            TextView textView = vhr.getView(R.id.id_num);
            final Button btn_add = vhr.getView(R.id.btn_add);
            final Button btn_delete = vhr.getView(R.id.btn_delete);
            textView.setText(mDatas.get(position));
            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
                    builder.setTitle("输入添加内容");
                    final EditText editText = new EditText(context);
                    builder.setView(editText);
                    builder.setPositiveButton("确定", new AlertDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mDatas.add( editText.getText().toString());
                            notifyDataSetChanged();
                            btn_add.setVisibility(View.GONE);
                            btn_delete.setVisibility(View.GONE);
                        }
                    });
                    builder.setNegativeButton("取消", new AlertDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            btn_add.setVisibility(View.GONE);
                            btn_delete.setVisibility(View.GONE);
                        }
                    });
                    builder.show();
                }
            });
            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDatas.remove(position);
                    notifyDataSetChanged();
                    btn_add.setVisibility(View.GONE);
                    btn_delete.setVisibility(View.GONE);
                }
            });
            vhr.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Click" + position, Toast.LENGTH_SHORT).show();
                }
            });
            vhr.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(context, "Long Click" + position, Toast.LENGTH_SHORT).show();
                    btn_add.setVisibility(View.VISIBLE);
                    btn_delete.setVisibility(View.VISIBLE);
                    return true;
                }
            });
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
