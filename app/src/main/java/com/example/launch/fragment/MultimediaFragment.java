package com.example.launch.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.launch.R;
import com.example.launch.util.MultimediaActivity;
import com.example.launch.util.ToolboxActivity;

public class MultimediaFragment extends Fragment {

    private ImageView dmt;

    public MultimediaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_multimedia, container, false);

        dmt = (ImageView) rootView.findViewById(R.id.dmt);
        dmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MultimediaActivity.class);
                startActivity(intent);
            }
        });

        return rootView;

    }

}