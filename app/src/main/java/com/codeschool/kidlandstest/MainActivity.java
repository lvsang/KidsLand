package com.codeschool.kidlandstest;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity{


    ActionBar actionbar;
    ViewPager viewpager;
    EngFragmanrAdapter ft;
    ImageButton imageButton;
    ImageButton imgbtnStart;
    ImageButton imgbtnLearnEng;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.mainscreen_layout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        imageButton = (ImageButton)findViewById(R.id.imgbtn_feedback);
        imgbtnStart = (ImageButton)findViewById(R.id.imgbtn_start);


        imgbtnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                btnStart_Onclick(v);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgbtn_feedback_Onclick(v);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void imgbtn_feedback_Onclick(View v)
    {
        Uri uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void  btnStart_Onclick(View v)
    {
        setContentView(R.layout.mainmenu_layout);
        imgbtnLearnEng = (ImageButton)findViewById(R.id.imageButton2);
        imgbtnLearnEng.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LearnEng_Click(v);
            }
        });
    }

    public void LearnEng_Click(View v)
    {
        setContentView(R.layout.learneng_layout);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Animal"));
        tabLayout.addTab(tabLayout.newTab().setText("Jobs"));
        tabLayout.addTab(tabLayout.newTab().setText("Nature"));
        tabLayout.addTab(tabLayout.newTab().setText("Vehicle"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final EngFragmanrAdapter adapter = new EngFragmanrAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                    if(tab.getPosition() == 0) {
                         player = MediaPlayer.create(getApplicationContext(), R.raw.animal);
                    }
                else if(tab.getPosition() == 1){
                        player = MediaPlayer.create(getApplicationContext(), R.raw.jobs);
                    }
                else if (tab.getPosition() == 2){
                        player = MediaPlayer.create(getApplicationContext(), R.raw.nature);
                    }
                else{
                        player = MediaPlayer.create(getApplicationContext(), R.raw.vehicle);
                    }

                player.start();


                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
