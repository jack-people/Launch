package com.example.launch;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Calendar;

import cn.hutool.core.builder.Builder;

public class FifthActivity extends Activity {
    private TextView tvlunar;
    private TextView SIM;
    private LinearLayout simContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fifth);

        tvlunar = (TextView) findViewById(R.id.tvlunar);
        tvlunar.setText(getDayLunar());

        SIM = (TextView) findViewById(R.id.SIM);
        SIM.setText(hasSimCard(this) ? "有SIM卡" : "无SIM卡");

    }
    /**
     * 判断是否包含SIM卡
     *
     * @return 状态
     */
    public static boolean hasSimCard(Context context) {
        TelephonyManager telMgr = (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);
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
//        Log.d("try", result ? "有SIM卡" : "无SIM卡");
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

