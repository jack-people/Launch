package com.example.launch.fragment;

import androidx.fragment.app.Fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.launch.R;

public class FourthFragment extends Fragment {

    private ImageButton camera;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View hiView = inflater.inflate(R.layout.fragment_fourth, container, false);

        camera = hiView.findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.camera2", "com.android.camera.CameraLauncher"));
                startActivity(intent);
            }
        });

        return hiView;
    }

}