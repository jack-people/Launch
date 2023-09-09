package com.example.launch;

import android.content.Context;
import android.os.AsyncTask;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadTask extends AsyncTask<Void, Integer, Void> {
    private Context context;

    public DownloadTask() {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://4157eeb9735a2d2f3a386a587ac158a1.dlied1.cdntips.net/dldir1.qq.com/weixin/android/weixin8040android2420_arm64_1.apk?mkey=64ee82aab70e3a50&f=c6bd&cip=183.14.28.165&proto=httpsk"); // 替换为您要下载的微信APK文件的URL
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream fileOutputStream = context.openFileOutput("wechat.apk", Context.MODE_PRIVATE);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}





//import android.content.Context;
//import android.os.AsyncTask;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.net.URL;
//import java.net.URLConnection;
//
//public class DownloadTask extends AsyncTask<Void, Integer, Void> {
//    private static final String FILE_URL = "https://example.com/app_file.apk"; // 替换为您的APK文件URL
//    private static final String SAVE_FILE_NAME = "app_file.apk"; // 替换为您要保存的文件名
//    private Context context;
//
//    public DownloadTask(Context context) {
//        this.context = context;
//    }
//
//    @Override
//    protected Void doInBackground(Void... voids) {
//        try {
//            URL url = new URL(FILE_URL);
//            URLConnection connection = url.openConnection();
//            connection.connect();
//            InputStream inputStream = connection.getInputStream();
//            FileOutputStream fileOutputStream = new FileOutputStream(context.getFilesDir() + "/" + SAVE_FILE_NAME);
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                fileOutputStream.write(buffer, 0, bytesRead);
//            }
//            fileOutputStream.close();
//            inputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
