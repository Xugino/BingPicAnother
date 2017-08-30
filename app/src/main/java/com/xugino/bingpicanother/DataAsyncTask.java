package com.xugino.bingpicanother;

import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

class DataAsyncTask extends AsyncTask<Integer,Void,Void> {

    DataAsyncTask(){
        super();
    }

    @Override
    protected Void doInBackground(Integer... param) {
        try{
            String path = "http://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=5&mkt=zh-CN";
            URL url = new URL(path);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setConnectTimeout(5000);
            urlConn.connect();
            if (urlConn.getResponseCode() == 200) {
                String data = readStream(urlConn.getInputStream());
                Log.i(TAG, "请求成功");
                Log.i(TAG, data);
            } else {
                Log.i(TAG, "请求失败");
            }
            urlConn.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String readStream(InputStream inputStream) throws IOException{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
        return  outputStream.toString();
    }
}
