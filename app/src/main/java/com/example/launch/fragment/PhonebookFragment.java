package com.example.launch.fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.launch.R;

public class PhonebookFragment extends Fragment {
    private ImageView phonebook;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View hiView = inflater.inflate(R.layout.fragment_phonebook, container, false);

        phonebook = hiView.findViewById(R.id.phonebook);
        phonebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.google.android.contacts",
                        "com.android.contacts.activities.PeopleActivity"));
                startActivity(intent);
            }
        });

        return hiView;
    }
}