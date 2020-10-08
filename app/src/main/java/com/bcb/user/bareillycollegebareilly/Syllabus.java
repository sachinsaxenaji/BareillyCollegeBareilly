package com.bcb.user.bareillycollegebareilly;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.bcb.user.bareillycollegebareilly.R;
import com.bcb.user.bareillycollegebareilly.Student;
import com.bcb.user.sillaybus.MyAdapter;
import com.bcb.user.sillaybus.Sdata;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class Syllabus extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lv;
    String sillaybust[];
    List<Sdata> sdatas;

//    public int[] sillaybus_colour= {
//
//            R.drawable.cerclebackgroundgreen,
//            R.drawable.cerclebackgroundpink,
//            R.drawable.cerclebackgroundpurple,
//            R.drawable.cerclebackgroundyellow,
//            R.color.colorPrimary,
//            R.color.red,
//            R.color.black_overlay,
//            R.color.cardview_dark_background,
//            R.color.cardview_shadow_end_color
//
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Sillaybus");


        lv = (ListView) findViewById(R.id.Listview);
        lv.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        sdatas=new ArrayList<Sdata>();
        sillaybust=getResources().getStringArray(R.array.main_title);
        for(int i=0;i<sillaybust.length;i++){

            Sdata sdata=new Sdata(sillaybust[i]);
            sdatas.add(sdata);
        }
        com.bcb.user.sillaybus.MyAdapter myAdapter=new MyAdapter(getApplicationContext(),sdatas);
        myAdapter.notifyDataSetChanged();
        lv.setAdapter(myAdapter);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==0) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://mjpru.ac.in/pdf/bca.pdf")));
        }
        if(i==1) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mjpru.ac.in/NoticeBoard/Syllabi/pdfNew%5CBBA.pdf")));

        }
        if(i==2) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://mjpru.ac.in/pdf/BScPhysics.pdf")));

        }
        if(i==3) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://mjpru.ac.in/pdf/BAHistory.pdf")));

        }
        if(i==4) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://mjpru.ac.in/pdf/BCom.pdf")));

        }
        if(i==5) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://mjpru.ac.in/pdf/PGDCA.pdf")));

        }
        if(i==6) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://mjpru.ac.in/pdf/BCom.pdf")));

        }
        if(i==7) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://mjpru.ac.in/pdf/BAEducation.pdf")));

        }
        if(i==8) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mjpru.ac.in/pdf/BLib.pdf")));

        }
    }
}