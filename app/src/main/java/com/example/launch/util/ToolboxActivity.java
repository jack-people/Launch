package com.example.launch.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.viewpager.widget.ViewPager;
import com.example.launch.R;

public class ToolboxActivity extends Activity {

    Button confirm;
    Button back;
    Button calculator;
    Button clock;
    Button callblocking;
    Button calendar;
    Button filemanager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbox);

        confirm = findViewById(R.id.confirm);
        back = findViewById(R.id.back);
        calculator = findViewById(R.id.calculator);
        clock = findViewById(R.id.clock);
        callblocking = findViewById(R.id.callblocking);
        calendar = findViewById(R.id.calendar);
        filemanager = findViewById(R.id.filemanager);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ViewPager viewPager = findViewById(R.id.viewPager);

        filemanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.google.android.apps.nbu.files",
                        "com.google.android.apps.nbu.files.home.HomeActivity"));
                startActivity(intent);
            }
        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = makeLaunchIntent(new ComponentName("com.google.android.calendar",
                        "com.android.calendar.AllInOneActivity"));
                startActivity(intent);
            }

        });

        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.deskclock",
                        "com.android.deskclock.DeskClock"));
                startActivity(intent);
            }
        });

        callblocking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.sprd.firewall",
                        "com.sprd.firewall.ui.CallFireWallActivity"));
                startActivity(intent);
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.google.android.calculator",
                        "com.android.calculator2.Calculator"));
                startActivity(intent);
//                Intent intent = new Intent();
//                intent.setClass(ToolboxActivity.this,
//                        calculatorActivity.class);
//                startActivity(intent);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.deskclock",
                        "com.android.deskclock.DeskClock"));
                startActivity(intent);
            }
        });

//        confirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int currentItem = viewPager.getCurrentItem();
//                Intent intent = new Intent();
//
//                switch (currentItem) {
//                    case 0:
//                        intent.setClass(ToolboxActivity.this, calculatorActivity.class);
//                        break;
//
//                    // 添加更多的case语句来处理其他页面的跳转
//
//                    default:
//                        // 默认情况下跳转到某个默认的Activity
//                        intent.setClass(ToolboxActivity.this, ToolboxActivity.class);
//                        break;
//                }
//
//                startActivity(intent);
//            }
//        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public static Intent makeLaunchIntent(ComponentName cn) {
        return new Intent(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_LAUNCHER)
                .setComponent(cn)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
    }

}