package com.example.launch.fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.launch.R;

public class SmsFragment extends Fragment {
    private ImageView sms;

    public SmsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View hiView = inflater.inflate(R.layout.fragment_sms, container, false);

        sms = hiView.findViewById(R.id.sms);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.google.android.apps.messaging",
                        "com.google.android.apps.messaging.ui.ConversationListActivity"));
                startActivity(intent);
            }
        });

        return hiView;
    }

}