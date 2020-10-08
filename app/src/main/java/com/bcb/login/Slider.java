package com.bcb.login;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bcb.user.bareillycollegebareilly.MainScreen;
import com.bcb.user.bareillycollegebareilly.R;

public class Slider extends AppCompatActivity {

//    private EditText t1,t2;
//    private FirebaseAuth mAuth;
//    private ProgressBar p1;
    private ViewPager viewPager;
    private LinearLayout mlinearLayout;

    private SlideAdapter slideAdapter;

    private TextView[] mDots;
    private Button mnextbtn;
    private Button mbackbtn;
    private Button mfinish;
    private int mCurrentpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slider);
        getSupportActionBar().hide();

        viewPager=(ViewPager)findViewById(R.id.introv);
        mlinearLayout=(LinearLayout)findViewById(R.id.mDotsLayout);
        slideAdapter = new SlideAdapter(this);
        mnextbtn = (Button)findViewById(R.id.next);
        mbackbtn = (Button)findViewById(R.id.back);
        mfinish = (Button)findViewById(R.id.finish);


        viewPager.setAdapter(slideAdapter);

        viewPager.setAdapter(slideAdapter);


      addDotsIndicater(0);

        viewPager.addOnPageChangeListener(ViewListner);

        mnextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    viewPager.setCurrentItem(mCurrentpage + 1);

//                if(mCurrentpage  3){
//                    startActivity(new Intent(Slider.this, MainScreen.class));
//               finish();
//                }
            }
        });


        mbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mCurrentpage -1);
            }
        });

        mfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Slider.this, MainScreen.class));
              finish();
            }
        });

//        mAuth = FirebaseAuth.getInstance();
//
//        t1 = (EditText)findViewById(R.id.email);
//        t2= (EditText)findViewById(R.id.password);
//        p1= (ProgressBar) findViewById(R.id.progressBar);
    }

    public void addDotsIndicater( int position){
        mDots = new TextView[4];
        mlinearLayout.removeAllViews();

        for (int i=0; i<mDots.length; i++)
        {

            mDots[i]= new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.black));

            mlinearLayout.addView(mDots[i]);


            //mDots[i].setTextColor(getResources().getColor(R.color.yello));

        }

        if(mDots.length > 0){


            mDots[position].setTextColor(getResources().getColor(R.color.yello));
        }
    }

    ViewPager.OnPageChangeListener ViewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicater(i);
            mCurrentpage = i;
            if(i == 0)
            {

                mnextbtn.setEnabled(true);
                mbackbtn.setEnabled(false);
                mfinish.setEnabled(false);
                mbackbtn.setVisibility(View.INVISIBLE);
                mnextbtn.setText("NEXT");
                mbackbtn.setText("BACK");
                mfinish.setText("");

            }else if (i == 1)
            {

                    mnextbtn.setEnabled(true);
                    mbackbtn.setEnabled(true);
                    mfinish.setEnabled(false);
                    mbackbtn.setVisibility(View.VISIBLE);
                    mnextbtn.setText("NEXT");
                    mbackbtn.setText("BACK");
                    mfinish.setText("");


            }else if(i == 2)
            {

                mnextbtn.setEnabled(true);
                mbackbtn.setEnabled(true);
                mfinish.setEnabled(false);
                mbackbtn.setVisibility(View.VISIBLE);
                mnextbtn.setText("NEXT");
                mbackbtn.setText("BACK");
                mfinish.setText("");
//                startActivity(new Intent(Slider.this,MainScreen.class));
//                           finish();

            }
        else if(i == 3) {

                mnextbtn.setEnabled(false);
                mbackbtn.setEnabled(true);
                mfinish.setEnabled(true);
                mfinish.setVisibility(View.VISIBLE);
                mnextbtn.setText("");
                mbackbtn.setText("BACK");
                mfinish.setText("FINISH");
//                startActivity(new Intent(Slider.this, MainScreen.class));
//                finish();
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



//    public void click(View view) {
//        String email = t1.getText().toString();
//        String password = t2.getText().toString();
//        if(email.equals("")|password.equals("")) {
//            Toast.makeText(this, "please fill all the information", Toast.LENGTH_SHORT).show();
//            p1.setVisibility(View.GONE);
//
//        }
//
//        p1.setVisibility(View.VISIBLE);
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d("MSG", "signInWithEmail:success");
//                            Toast.makeText(Slider.this, "Slider sucessfully", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(Slider.this,MainScreen.class));
//                            finish();
//                            p1.setVisibility(View.GONE);
////                            FirebaseUser user = mAuth.getCurrentUser();
////                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w("Messege", "signInWithEmail:failure", task.getException());
//                            Toast.makeText(Slider.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            p1.setVisibility(View.GONE);
//                            //updateUI(null);
//                        }
//
//                        // ...
//                    }
//                });
//
//
//    }
//
//    public void register(View view) {
//
//        startActivity(new Intent(Slider.this,SignUp.class));
//    }
}
