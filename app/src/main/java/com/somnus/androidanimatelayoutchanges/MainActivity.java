package com.somnus.androidanimatelayoutchanges;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLinearLayout;
    private LinearLayout mll_layout_01;


    LayoutTransition mTransitioner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mLinearLayout = (LinearLayout) findViewById(R.id.ll_layout);
        mll_layout_01 = (LinearLayout) findViewById(R.id.ll_layout_01);

        mTransitioner = new LayoutTransition();
        //入场动画:view在这个容器中消失时触发的动画
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "rotationY", 0f, 360f, 0f);
        mTransitioner.setAnimator(LayoutTransition.APPEARING, animIn);

        //出场动画:view显示时的动画
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
        mTransitioner.setAnimator(LayoutTransition.DISAPPEARING, animOut);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("ADD", null).show();
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
        if (id == R.id.action_add) {
            Button button = new Button(MainActivity.this);
            button.setText("" + new Random().nextInt(100));
            mLinearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mLinearLayout.removeView(view);
                }
            });
            return true;
        } else if (id == R.id.action_add1) {
            //自定义动画

            Button button = new Button(MainActivity.this);
            button.setText("" + new Random().nextInt(100));
            mll_layout_01.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mll_layout_01.removeView(view);
                }
            });

            mll_layout_01.setLayoutTransition(mTransitioner);
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onBackPressed() {
       /*写在主页 ， 按返回键返回桌面，不结束Activity*/
        moveTaskToBack(true);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("tag",keyCode+"");
        Log.d("event",event.toString());
        return super.onKeyDown(keyCode, event);
    }

    public void onAction(View v){
        Toast.makeText(this, "啦啦啦", Toast.LENGTH_SHORT).show();
    }
}
