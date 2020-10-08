package com.bcb.user.bareillycollegebareilly;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bcb.Doveloper;
import com.bcb.login.Slider;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    CardView about,course,syllabus,teachers,contact;
    ViewFlipper v_flipper;
    private boolean exit=false ;
    Sqldatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDb = new Sqldatabase(this);
        about = (CardView) findViewById(R.id.about);
        course = (CardView) findViewById(R.id.course);
        syllabus = (CardView) findViewById(R.id.syllabus);
        teachers = (CardView) findViewById(R.id.teachers);
        contact = (CardView) findViewById(R.id.contact);

        about.setOnClickListener(this);
        course.setOnClickListener(this);
        syllabus.setOnClickListener(this);
        teachers.setOnClickListener(this);
        contact.setOnClickListener(this);




        int images[] = {R.drawable.bca, R.drawable.blclg, R.drawable.bcb, R.drawable.bcbl};
        v_flipper = (ViewFlipper) findViewById(R.id.v_flipper);




//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);


        for (int image : images) {
            flipperImages(image);
        }
    }

    private int images(int i) {
        return 0;
    }


    public void flipperImages(int image)
    {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            if (exit) {
                finish();
            } else {
                Toast.makeText(MainScreen.this, "Press Again to exit", Toast.LENGTH_SHORT).show();

            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    exit = false;

                }
            }, 1700);

            exit = true;



        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // SlideAdapter the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bcb) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://bareillycollege.org/")));
            // Handle the camera action
        } else if (id == R.id.nav_mjpru) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mjpru.ac.in/")));
        }

        else if (id == R.id.nav_logout) {

            finish();
        }

        else if (id == R.id.nav_privacy) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://pdprivacy.blogspot.com/p/privacy.html")));

        } else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://play.google.com/store/apps/details?id=com.bcb.bareilly";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        } else if (id == R.id.nav_rating) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.bcb.bareilly")));

        }
        else if (id == R.id.nav_dovelopera) {

            startActivity(new Intent(this, Doveloper.class));

        }
        else if (id == R.id.nav_doveloper) {

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sachinsaxena7228@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT,"subject");
            intent.putExtra(Intent.EXTRA_TEXT,"mail body");
            startActivity(Intent.createChooser(intent,""));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

            Intent i;
            switch (view.getId()) {


                case R.id.teachers:
                    i = new Intent(this, Events.class);
                    startActivity(i);
                    break;
                case R.id.about:
                    i = new Intent(this, about.class);
                    startActivity(i);
                    break;
                case R.id.course:

                    i = new Intent(this, course.class);
                    startActivity(i);
                    break;
                case R.id.syllabus:
                    i = new Intent(this, Syllabus.class);
                    startActivity(i);
                    break;
                case R.id.contact:
                    i = new Intent(this, contact.class);
                    startActivity(i);
                    break;


                default:
                    break;
            }
        }
    }