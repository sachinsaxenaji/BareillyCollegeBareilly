package com.bcb.user.bareillycollegebareilly;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bcb.login.Slider;
import com.google.firebase.auth.FirebaseAuth;

public class Splash extends AppCompatActivity {

    private ImageView iv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        iv=(ImageView)findViewById(R.id.iv);
        tv=(TextView)findViewById(R.id.tv);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.myanimation);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);
        myanim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
//                if(FirebaseAuth.getInstance().getCurrentUser()!=null){
//                    startActivity(new Intent(Splash.this,MainScreen.class));
//                }

//                SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
//                if (pref.getBoolean("activity_executed", true)) {
//                    startActivity(new Intent(Splash.this,Slider.class));
//                    finish();
//                } else if (pref.getBoolean("activity_executed", false)) {
//                    startActivity(new Intent(Splash.this,MainScreen.class));
//                    finish();
//                }

                Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                        .getBoolean("isFirstRun", true);

                if (isFirstRun) {
                    //show sign up activity
                    startActivity(new Intent(Splash.this, Slider.class));

                }else {
                    startActivity(new Intent(Splash.this, MainScreen.class));


                }


                getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                        .putBoolean("isFirstRun", false).commit();
//                else {
                   // startActivity(new Intent(Splash.this,Slider.class));
           //     }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
