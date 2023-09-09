package com.example.launch.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.launch.R;
import com.example.launch.util.ToolboxActivity;


public class ToolboxFragment extends Fragment {
    private ImageView gjx;

    public ToolboxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_toolbox, container, false);

        gjx = (ImageView) rootView.findViewById(R.id.gjx);
        gjx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ToolboxActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
