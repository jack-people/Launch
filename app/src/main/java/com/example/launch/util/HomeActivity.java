package com.example.launch.util;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.launch.MyPagerAdapter;
import com.example.launch.R;
import com.example.launch.fragment.AccelerateFragment;
import com.example.launch.fragment.MultimediaFragment;
import com.example.launch.fragment.PhonebookFragment;
import com.example.launch.fragment.PhonecallFragment;
import com.example.launch.fragment.SettingFragment;
import com.example.launch.fragment.SmsFragment;
import com.example.launch.fragment.ToolboxFragment;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends FragmentActivity {

    Button confirm,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        confirm = findViewById(R.id.confirm);
        back = findViewById(R.id.back);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ViewPager viewPager = findViewById(R.id.viewPager);
        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new SettingFragment());
        fragments.add(new SmsFragment());
        fragments.add(new MultimediaFragment());
        fragments.add(new ToolboxFragment());
        fragments.add(new PhonebookFragment());
        fragments.add(new PhonecallFragment());
        fragments.add(new AccelerateFragment());

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager.getCurrentItem();
                Intent intent = new Intent();

                switch (currentItem) {
                    case 0:
                        Intent settingintent = new Intent();
                        settingintent.setComponent(new ComponentName("com.android.settings",
                                "com.android.settings.Settings"));
                        startActivity(settingintent);
                        break;
                    case 1:
                        Intent smsintent = new Intent();
                        smsintent.setComponent(new ComponentName("com.google.android.apps.messaging",
                                "com.google.android.apps.messaging.ui.ConversationListActivity"));
                        startActivity(smsintent);
                        break;
                    case 2:
                        intent.setClass(HomeActivity.this, MultimediaActivity.class);
                        break;
                    case 3:
                        intent.setClass(HomeActivity.this, ToolboxActivity.class);
                        break;
                    case 4:
                        Intent phonebookintent = new Intent();
                        intent.setComponent(new ComponentName("com.google.android.contacts",
                                "com.android.contacts.activities.PeopleActivity"));
                        startActivity(intent);
                        break;
                    case 5:
                        Intent phonecallintent = new Intent();
                        intent.setComponent(new ComponentName("com.google.android.dialer",
                                "com.google.android.dialer.extensions.GoogleDialtactsActivity"));
                        startActivity(intent);
                        break;
                    case 6:
                        intent.setClass(HomeActivity.this, AccelerateFragment.class);
                        break;

                    // 添加更多的case语句来处理其他页面的跳转

                    default:
                        // 默认情况下跳转到某个默认的Activity
                        intent.setClass(HomeActivity.this, HomeActivity.class);
                        break;
                }

                startActivity(intent);

            }
        });

//        confirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(HomeActivity.this,
//                        MultimediaActivity.class);
//                startActivity(intent);
//            }
//        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder ab = new AlertDialog.Builder(HomeActivity.this);
//                ab.setTitle("提示");
//                ab.setMessage("您是否确定退出？");
//                ab.setPositiveButton("取消", null);
//                ab.setNeutralButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        HomeActivity.this.finish();
//                    }
//                });
//                ab.create();
//                ab.show();
//            }
//        });
    }

}
