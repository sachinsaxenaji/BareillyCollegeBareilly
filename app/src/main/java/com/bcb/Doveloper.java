package com.bcb;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bcb.user.bareillycollegebareilly.R;

public class Doveloper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doveloper);
//        getSupportActionBar().hide();
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Developer's Profile");
    }
}
