package com.example.launch.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.viewpager.widget.ViewPager;
import com.example.launch.R;

public class MultimediaActivity extends Activity {

    Button confirm,back,music,camera,recorder,gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);

        ViewPager viewPager = findViewById(R.id.viewPager);
        confirm = findViewById(R.id.confirm);
        back = findViewById(R.id.back);
        music = findViewById(R.id.music);
        camera = findViewById(R.id.camera);
        recorder = findViewById(R.id.recorder);
        gallery = findViewById(R.id.gallery);

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.google.android.apps.youtube.music",
                        "com.google.android.apps.youtube.music.activities.MusicActivity"));
                startActivity(intent);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.camera2", "com.android.camera.CameraLauncher"));
                startActivity(intent);
            }
        });

        recorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.soundrecorder",
                        "com.sprd.soundrecorder.RecorderActivity"));
                startActivity(intent);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.google.android.apps.photos",
                        "com.google.android.apps.photos.home.HomeActivity"));
                startActivity(intent);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.google.android.apps.youtube.music",
                        "com.google.android.apps.youtube.music.activities.MusicActivity"));
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
//                        Intent musicintent = new Intent();
//                        musicintent.setComponent(new ComponentName("com.google.android.apps.youtube.music",
//                                "com.google.android.apps.youtube.music.activities.MusicActivity")););
//                        startActivity(musicintent);
//                        break;
//                    case 1:
//                        Intent cameraintent = new Intent();
//                        cameraintent.setComponent(new ComponentName("com.android.camera2",
//                                "com.android.camera.CameraLauncher"));
//                        startActivity(cameraintent);
//                        break;
//                    case 2:
//                        Intent recorderintent = new Intent();
//                        recorderintent.setComponent(new ComponentName("com.android.soundrecorder",
//                                "com.sprd.soundrecorder.RecorderActivity"));
//                        startActivity(recorderintent);
//                        break;
//                    case 3:
//                        Intent galleryintent = new Intent();
//                        intent.setComponent(new ComponentName("com.google.android.apps.photos",
//                                "com.google.android.apps.photos.home.HomeActivity"));
//                        startActivity(intent);
//                        break;
//
//                    // 添加更多的case语句来处理其他页面的跳转
//
//                    default:
//                        // 默认情况下跳转到某个默认的Activity
//                        intent.setClass(MultimediaActivity.this, MultimediaActivity.class);
//                        break;
//                }
//
//                startActivity(intent);
//
//            }
//        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
