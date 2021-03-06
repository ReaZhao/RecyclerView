package com.reazha.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * @author ReaZhao
 * @date 2016/12/9
 * @FileName ViewHolderRecycler
 * @E-mail 377742053qq.com
 * @desc 优化RecyclerView
 */

public class ViewHolderRecycler extends RecyclerView.ViewHolder {
    public SparseArray<View> views = new SparseArray<View>();
    private View view;

    public ViewHolderRecycler(View itemView) {
        super(itemView);
        this.view = itemView;

    }

    public <T extends View> T getView(int resId) {
        View v=views.get(resId);
        if(v==null){
            v=view.findViewById(resId);
            views.put(resId,v);
        }
        return (T) v;
    }
//    public interface OnItemClickLinstener{
//        void OnItemClick(ViewHolderRecycler view, int position);
//        void OnItemLongClick(ViewHolderRecycler view, int position);
//    }
//    public OnItemClickLinstener mOnItemClickLinstener;
//    public void setOnItemClickLinstener(OnItemClickLinstener linstener){
//        this.mOnItemClickLinstener=linstener;
//    }
}
