package com.bcb.user.bareillycollegebareilly;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

//import com.firebase.ui.database.FirebaseListAdapter;
//import com.firebase.ui.database.FirebaseListOptions;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.squareup.picasso.Picasso;

import com.bcb.user.course.Ba;
import com.bcb.user.course.Bba;
import com.bcb.user.course.Bca;
import com.bcb.user.course.Bcom;
import com.bcb.user.course.Bcomh;
import com.bcb.user.course.Bsc;
import com.bcb.user.course.Med;
import com.bcb.user.course.Mlib;
import com.bcb.user.course.Pgdca;

import java.util.ArrayList;
import java.util.List;

public class course extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    List<RowData> rowDatas;
    String main_title[],sub_title[];
    TypedArray image_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Couse");

        listView= (ListView) findViewById(R.id.Listview);
        listView.setOnItemClickListener(this);

        rowDatas=new ArrayList<RowData>();
        main_title=getResources().getStringArray(R.array.main_title);
        sub_title=getResources().getStringArray(R.array.sub_title);
        image_title=getResources().obtainTypedArray(R.array.image_title);

        for(int i=0;i<main_title.length;i++){

            RowData rowData=new RowData(main_title[i],sub_title[i],image_title.getResourceId(i,-1));
            rowDatas.add(rowData);
        }

        MyAdapter myAdapter=new MyAdapter(getApplicationContext(),rowDatas);
        myAdapter.notifyDataSetChanged();
        listView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)

    {
        if(i==0) {
            Intent intent = new Intent(course.this, Bca.class);
            startActivity(intent);
        }
        if(i==1) {
            Intent intent = new Intent(course.this, Bba.class);
            startActivity(intent);
        }
        if(i==2) {
            Intent intent = new Intent(course.this, Bsc.class);
            startActivity(intent);
        }
        if(i==3) {
            Intent intent = new Intent(course.this, Ba.class);
            startActivity(intent);
        }
        if(i==4) {
            Intent intent = new Intent(course.this, Bcom.class);
            startActivity(intent);
        }
        if(i==5) {
            Intent intent = new Intent(course.this, Pgdca.class);
            startActivity(intent);
        }
        if(i==6) {
            Intent intent = new Intent(course.this, Bcomh.class);
            startActivity(intent);
        }
        if(i==7) {
            Intent intent = new Intent(course.this, Med.class);
            startActivity(intent);
        }
        if(i==8) {
            Intent intent = new Intent(course.this, Mlib.class);
            startActivity(intent);
        }



    }
}
