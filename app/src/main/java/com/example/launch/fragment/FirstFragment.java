package com.example.launch.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.launch.LunarCalender;
import com.example.launch.R;
import java.util.Calendar;

public class FirstFragment extends Fragment {
    private TextView tvlunar;
    private TextView SIM;
    private LinearLayout simLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first,
                container, false);

        tvlunar = (TextView) rootView.findViewById(R.id.tvlunar);
        tvlunar.setText(getDayLunar());

        SIM = (TextView) rootView.findViewById(R.id.SIM);
        SIM.setText(hasSimCard()? getSimOperatorInfo() : "请插入SIM卡！");
//        SIM.setText(hasSimCard()? getSimOperatorName() : "请插入SIM卡！");
//        SIM.setText(hasSimCard(getContext()) ? "有SIM卡" : "请插入SIM卡！");

        return rootView;
    }

    private void showSimCardInfo() {
        TelephonyManager telMgr = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        int simCount = getSimCardCount();
        for (int i = 0; i < simCount; i++) {
            TextView simTextView = new TextView(getContext());
            simTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            simTextView.setText(getSimOperatorInfo(telMgr, i));
            simLayout.addView(simTextView);
        }
    }

    private String getSimOperatorInfo(TelephonyManager telMgr, int simIndex) {
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            String operatorName = telMgr.getSimOperatorName();
            int networkType = telMgr.getNetworkType();
            String networkTypeName = getNetworkTypeName(networkType);
            return "SIM " + (simIndex + 1) + ": " + operatorName + " " + networkTypeName;
        } else {
            return "Permission not granted";
        }
    }
    private String getSimOperatorInfo() {
        TelephonyManager telMgr = (TelephonyManager)
                getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        // Check if the READ_PHONE_STATE permission is granted
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_PHONE_STATE) ==
                PackageManager.PERMISSION_GRANTED){
            String operatorName = telMgr.getSimOperatorName();
            int networkType = telMgr.getNetworkType();
            String networkTypeName = getNetworkTypeName(networkType);
            return operatorName + " " + networkTypeName;
        }else {
            // Handle the case when the permission is not granted
            // You can request the permission from the user here
            // or handle the absence of permission in any other way
            return "Permission not granted";
        }
    }

    private String getNetworkTypeName(int networkType) {
        switch (networkType) {
            case TelephonyManager.NETWORK_TYPE_LTE:
                return "4G";
            case TelephonyManager.NETWORK_TYPE_NR:
                return "5G";
            default:
                return "Unknown";
        }
    }

//    private String getSimOperatorName() {
//        TelephonyManager telMgr = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
//        String operatorName = telMgr.getSimOperatorName();
//        return operatorName;
//    }

    private int getSimCardCount() {
        TelephonyManager telMgr = (TelephonyManager)
                getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_PHONE_STATE) ==
                PackageManager.PERMISSION_GRANTED) {
            return telMgr.getPhoneCount();
        } else {
            // Handle the case when the permission is not granted
            // You can request the permission from the user here
            // or handle the absence of permission in any other way
            return 0;
        }
    }

    private boolean hasSimCard() {
//        TelephonyManager telMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        TelephonyManager telMgr = (TelephonyManager)
                getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        int simState = telMgr.getSimState();
        boolean result = true;
        switch (simState) {
            case TelephonyManager.SIM_STATE_ABSENT:
                result = false; // 没有SIM卡
                break;
            case TelephonyManager.SIM_STATE_UNKNOWN:
                result = false;
                break;
        }
        return result;
    }

    /**
     * 获取现在农历的日期
     */
    public static String getDayLunar() {
        LunarCalender lunarCalender = new LunarCalender();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        String lunarString = lunarCalender.getLunarString(year, month, day);
        return lunarString;
    }

}

