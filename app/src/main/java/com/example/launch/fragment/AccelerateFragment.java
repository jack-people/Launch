package com.example.launch.fragment;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.launch.R;

public class AccelerateFragment extends Fragment {

    private ImageView acceleration;
    private TextView tip;
    private static final int ICON_SPEED = 3;
    private long mSpeedLastClickTime = 0; // 修改为非 final 变量
    private static final String TAG = "AccelerateFragment";
    private static final int CLEAN_BACKGROUND_PROCESS = 8;
    private static final int DELAY_CLEAN_BACKGROUND_PROCESS_TIME = 200;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View hiView = inflater.inflate(R.layout.fragment_accelerate, container, false);

        acceleration = hiView.findViewById(R.id.acceleration);
        tip = hiView.findViewById(R.id.tip);
        acceleration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 清理内存（这里不建议使用 System.gc()）
                // 等待一段时间后显示结果
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 计算内存减少量（这里只是一个示例，你需要根据实际情况进行计算）
                        long memoryReduction = calculateMemoryReduction();
                        // 显示结果信息（建议使用 StringBuilder 或者 StringBuffer 进行字符串拼接）
                        StringBuilder tipText = new StringBuilder("内存占用减少量：");
                        tipText.append(memoryReduction);
                        tipText.append("MB\n加速效果：更快");
                        tip.setText(tipText.toString());
                    }
                }, 1000); // 等待1秒后显示结果
                mSpeedLastClickTime = System.currentTimeMillis(); // 更新点击时间
            }
        });

        return hiView;
    }

    // 计算内存减少量的方法，这里只是一个示例，你需要根据实际情况进行计算
    private long calculateMemoryReduction() {
        ActivityManager activityManager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();

        // 获取初始内存使用情况
        activityManager.getMemoryInfo(memoryInfo);
        long initialMemoryUsage = memoryInfo.totalMem;

        // 执行一键加速操作（这里可以使用你自己的逻辑）
        // ...

        // 再次获取当前内存使用情况
        activityManager.getMemoryInfo(memoryInfo);
        long currentMemoryUsage = memoryInfo.totalMem;

        // 计算内存减少量（以MB为单位）
        long memoryReduction = (initialMemoryUsage - currentMemoryUsage) / 1024 / 1024;

        return memoryReduction;
    }

}
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        try {
//            if (ICON_SPEED == position) {
//                mSpeedLastClickTime = SystemClock.uptimeMillis();
//                handler.removeMessages(CLEAN_BACKGROUND_PROCESS);
//                handler.sendEmptyMessageDelayed(CLEAN_BACKGROUND_PROCESS, DELAY_CLEAN_BACKGROUND_PROCESS_TIME);
//            } else {
//                startActivity(intentForPosition(position));
//            }
//        } catch (ActivityNotFoundException e) {
//            Log.i(TAG, "App not found");
//            Toast.makeText(getActivity(), R.string.activity_not_found, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    protected Intent intentForPosition(int position) {
//        T info = getData(position);
//        Intent intent = new Intent();
//        if (info != null) {
//            intent.setClassName(info.getAppPkg(), info.getAppClassName());
//        }
//        AppIntentUtil.intentSetFlag(intent);
//        return intent;
//    }
//
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            if (mGridView != null) {
//                View view = mGridView.getChildAt(3);
//                if(view == null){
//                    Log.d(TAG, "ICON_SPEED view is null");
//                    return;
//                }
//                ImageView img = (ImageView) view
//                        .findViewById(R.id.app_item_icon);
//                switch (msg.what) {
//                    case START_ANIMATION: {
//                        // clear iconAnimation when click speed
//                        if (cleanAnimation != null) {
//                            view.clearAnimation();
//                            img.setImageDrawable(getActivity().getResources()
//                                    .getDrawable(
//                                            R.drawable.app_speed));
//                            img.startAnimation(cleanAnimation);
//                        }
//                        break;
//                    }
//
//                    case STOP_ANIMATION: {
//                        int processCount = msg.arg1;
//                        int availableMemory = msg.arg2;
//                        img.clearAnimation();
//                        if(mAdapter instanceof FourthPageAdapter) {
//                            ((FourthPageAdapter) mAdapter).updateSpeedView();
//                        }
//                        Toast.makeText(getActivity(),
//                                getActivity().getResources().getString(
//                                        R.string.clean_toast_prompt,
//                                        processCount, availableMemory),
//                                Toast.LENGTH_LONG).show();
//                        break;
//                    }
//
//                    case UPDATE_SPEED_VIEW: {
//                        if(mAdapter instanceof FourthPageAdapter) {
//                            ((FourthPageAdapter) mAdapter).updateSpeedView();
//                        }
//                        break;
//                    }
//
//                    case CLEAN_BACKGROUND_PROCESS: {
//                        SecurityThread thread = new SecurityThread();
//                        thread.start();
//                        break;
//                    }
//                }
//            }
//        }
//    };

