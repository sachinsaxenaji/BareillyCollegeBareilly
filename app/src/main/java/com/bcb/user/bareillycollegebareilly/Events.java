package com.bcb.user.bareillycollegebareilly;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Events extends AppCompatActivity {

    RecyclerView mRecyclerView;
    DatabaseReference myRef;
    FirebaseDatabase database;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Events");

        mLayoutManager = new LinearLayoutManager(this);

        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        mRecyclerView=findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(mLayoutManager);

         database = FirebaseDatabase.getInstance();
         myRef = database.getReference("Data");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.event,
                        ViewHolder.class,
                        myRef

                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {

                        viewHolder.setDetails(getApplicationContext(),model.getTitle(), model.getImage(), model.getDescription() );
                    }
                };
       
       // mRecyclerView.reverse(firebaseRecyclerAdapter);
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

}
