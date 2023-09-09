package com.example.launch.fragment;

import androidx.fragment.app.Fragment;
import android.app.DownloadManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.launch.R;

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View hiView = inflater.inflate(R.layout.fragment_second, container, false);

        ImageButton camera = hiView.findViewById(R.id.camera);
        ImageView weixinIcon = hiView.findViewById(R.id.weixinIcon);
        Button downloadWeChat = hiView.findViewById(R.id.downloadWeChat);
        Button downloadalipay = hiView.findViewById(R.id.downloadalipay);
        Button douyin = hiView.findViewById(R.id.douyin);
        Button xiguashiping = hiView.findViewById(R.id.xiguashiping);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.camera2", "com.android.camera.CameraLauncher"));
                startActivity(intent);
            }
        });

        downloadWeChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://4157eeb9735a2d2f3a386a587ac158a1.dlied1.cdntips.net/dldir1.qq.com/weixin/android/weixin8040android2420_arm64_1.apk?mkey=64ee82aab70e3a50&f=c6bd&cip=183.14.28.165&proto=httpsk";
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.setTitle("微信下载");
                request.setDescription("正在下载微信应用");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "weixin8040android2420_arm64_1.apk");

                DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);
            }
        });

        downloadalipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://tfs.alipayobjects.com/L1/71/100/and/alipay_wap_main_64.apk";
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.setTitle("支付宝下载");
                request.setDescription("正在下载支付宝应用");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "alipay_wap_main_64.apk");

                DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);
            }
        });

        douyin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://lf9-apk.ugapk.cn/package/apk/aweme/5072_260801/aweme_douyinweb1_64_v5072_260801_ba05_1693227928.apk?v=1693227943";
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.setTitle("抖音下载");
                request.setDescription("正在下载抖音应用");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "aweme_douyinweb1_64_v5072_260801_ba05_1693227928.apk");

                DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);
            }
        });

//        xiguashiping.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = "https://lf9-apk.ugapk.cn/package/apk/aweme/5072_260801/aweme_douyinweb1_64_v5072_260801_ba05_1693227928.apk?v=1693227943";
//                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
//                request.setTitle("西瓜视频下载");
//                request.setDescription("正在下载西瓜视频应用");
//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "aweme_douyinweb1_64_v5072_260801_ba05_1693227928.apk");
//
//                DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
//                downloadManager.enqueue(request);
//            }
//        });


        return hiView;
    }

//    public void DownloadTask(View view) {
//        String apkUrl = "https://4157eeb9735a2d2f3a386a587ac158a1.dlied1.cdntips.net/dldir1.qq.com/weixin/android/weixin8040android2420_arm64_1.apk?mkey=64ee82aab70e3a50&f=c6bd&cip=183.14.28.165&proto=httpsk";
//        String fileName = apkUrl.substring(apkUrl.lastIndexOf("/") + 1);
//
//        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(apkUrl));
//        request.setTitle("下载" + fileName);
//        request.setDescription("正在下载" + fileName);
//        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
//
//        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
//        manager.enqueue(request);
//    }
//
//    private Object getSystemService(String downloadService) {
//        // 检查传递的字符串是否为有效的下载服务
//        if (downloadService.equals(Context.DOWNLOAD_SERVICE)) {
//            return getContext().getSystemService(downloadService);
//        } else {
//            // 如果不是有效的下载服务，则返回null或其他适当的默认值
//            return null;
//        }
//    }

}