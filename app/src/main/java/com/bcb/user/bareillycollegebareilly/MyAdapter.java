package com.bcb.user.bareillycollegebareilly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context applicationContext;
    List<RowData> rowDatas;

    public MyAdapter(Context applicationContext, List<RowData> rowDatas) {
        this.applicationContext=applicationContext;
        this.rowDatas=rowDatas;
    }

    @Override
    public int getCount() {
        return rowDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return rowDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class MyViewHolder
    {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder myViewHolder=null;
//        if(view==null){

            LayoutInflater layoutInflater=(LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.row,null);
            myViewHolder=new MyViewHolder();
            myViewHolder.textView1=(TextView) view.findViewById(R.id.main_title);
            myViewHolder.textView2=(TextView) view.findViewById(R.id.sub_title);
            myViewHolder.imageView=(ImageView) view.findViewById(R.id.image_title);


            RowData rowData=rowDatas.get(i);
            myViewHolder.textView1.setText(rowData.getMain_title());
            myViewHolder.textView2.setText(rowData.getSub_title());
            myViewHolder.imageView.setImageResource(rowData.getImage_title());
            view.setTag(myViewHolder);
//        }
//        else {
            myViewHolder=(MyViewHolder) view.getTag();

//        }

        return view;
    }
}
