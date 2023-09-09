package com.example.launch;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.launch.fragment.FirstFragment;
import com.example.launch.fragment.FourthFragment;
import com.example.launch.fragment.SecondFragment;
import com.example.launch.fragment.ThirdFragment;
import com.example.launch.util.HomeActivity;
import com.example.launch.util.PhonebookActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {

    Button menu,phonebook;
    private ViewPager mPager;
    private LinearLayout mLlDots;
    private LayoutInflater inflater;
    private List<View> mPagerList;
    private int pageCount = 4;//默认四个小点
    /**
     * 当前显示的是第几页
     */
    private int curIndex = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.menu);
        phonebook = findViewById(R.id.phonebook);
        mPager = (ViewPager) findViewById(R.id.viewPager);
        mLlDots = (LinearLayout) findViewById(R.id.ll_dots);
        inflater = LayoutInflater.from(this);

        // Create instances of your four fragments
        Fragment fragment1 = new FirstFragment();
        Fragment fragment2 = new SecondFragment();
        Fragment fragment3 = new ThirdFragment();
        Fragment fragment4 = new FourthFragment();

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);

        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList);
        mPager.setAdapter(pagerAdapter);
        //#FF9800：黄，#4CAF50：绿，#2196F3：蓝
//        String[] colors = {"#FF9800", "#4CAF50", "#2196F3", "#2196F3"};
//        for (int i = 0; i < pageCount; i++) {
//            LinearLayout mLL = (LinearLayout) inflater.inflate(R.layout.linearlayout, mPager, false);
//            mLL.setBackgroundColor(Color.parseColor(colors[i]));
//            mPagerList.add(mLL);
//        }
        //设置圆点
        setDotLayout();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                        HomeActivity.class);
                startActivity(intent);
            }
        });

        phonebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.google.android.dialer",
                        "com.google.android.dialer.extensions.GoogleDialtactsActivity"));
                startActivity(intent);
            }
        });


    }

    /**
     * 设置圆点
     */
    public void setDotLayout() {
        for (int i = 0; i < pageCount; i++) {
            mLlDots.addView(inflater.inflate(R.layout.dotview, null));
        }
        // 默认显示第一页
        mLlDots.getChildAt(0).setSelected(true);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 取消原点选中
                mLlDots.getChildAt(curIndex).setSelected(false);
                // 原点选中
                mLlDots.getChildAt(position).setSelected(true);
                curIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

//public class MainActivity extends FragmentActivity {
//
//    Button menu,phonebook;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_main);
//
//        menu = findViewById(R.id.menu);
//        phonebook = findViewById(R.id.phonebook);
//
//        ViewPager viewPager = findViewById(R.id.viewPager);
//        List<Fragment> fragments = new ArrayList<>();
//        fragments.add(new FirstFragment());
//        fragments.add(new SecondFragment());
//        fragments.add(new ThirdFragment());
//        fragments.add(new FourthFragment());
//
//        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
//        viewPager.setAdapter(adapter);
//
//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this,
//                        HomeActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        phonebook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this,
//                        PhonebookActivity.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//
//}
