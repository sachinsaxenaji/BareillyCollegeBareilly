package com.bcb.user.sillaybus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bcb.user.bareillycollegebareilly.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context applicationContext;
    List<Sdata> sDatas;
    LayoutInflater layoutInflater;

    public MyAdapter(Context applicationContext, List<Sdata> sData) {
        this.applicationContext = applicationContext;
        this.sDatas = sData;
    }

    @Override
    public int getCount() {
        return sDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return sDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    private class MyVHolder {

        public TextView textView1;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyVHolder myVHolder=null;
//        if(view==null){

        layoutInflater=(LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.sillaybus,null);
        myVHolder=new MyVHolder();
        myVHolder.textView1=(TextView) view.findViewById(R.id.sillaybust);
        Sdata sdata=sDatas.get(i);
        myVHolder.textView1.setText(sdata.getMain_title());
        view.setTag(myVHolder);
//        }
//        else {
        myVHolder=(MyVHolder) view.getTag();

//        }
        return view;
    }



}

//    public View getView(int i, View view, ViewGroup viewGroup) {
//        com.example.user.bareillycollegebareilly.MyAdapter.MyVHolder myVHolder=null;
////        if(view==null){
//
//        LayoutInflater layoutInflater=(LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        view = layoutInflater.inflate(R.layout.row,null);
//        myViewHolder=new com.example.user.bareillycollegebareilly.MyAdapter.MyViewHolder();
//        myViewHolder.textView1=(TextView) view.findViewById(R.id.sillaybust);
//
//        Sdata sdata=sDatas.get(i);
//        myViewHolder.textView1.setText(rowData.getMain_title());
//        view.setTag(myViewHolder);
////        }
////        else {
//        myViewHolder=(com.example.user.bareillycollegebareilly.MyAdapter.MyViewHolder) view.getTag();
//
////        }
//
//        return view;
//    }}