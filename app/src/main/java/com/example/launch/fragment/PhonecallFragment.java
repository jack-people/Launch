package com.example.launch.fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.launch.R;

public class PhonecallFragment extends Fragment {
    private ImageView phonecall;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View hiView = inflater.inflate(R.layout.fragment_phonecall, container, false);

        phonecall = hiView.findViewById(R.id.phonecall);
        phonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.google.android.dialer",
                        "com.google.android.dialer.extensions.GoogleDialtactsActivity"));
                startActivity(intent);
            }
        });

        return hiView;
    }
}