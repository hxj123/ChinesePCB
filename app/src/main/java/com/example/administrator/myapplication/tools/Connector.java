package com.example.administrator.myapplication.tools;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Connector {
    private static OkHttpClient client = new OkHttpClient();
    private static MediaType text = MediaType.parse("text/plain;charset=utf-8");
    public interface Callback{
        void callback(String jsonString);
    }
//    private static String host = "http://192.168.43.214:8080";
    private static String host = "http://192.168.1.238:8080";

    public static void sendRequest(String url, JSONObject object, final Callback callback) {
        try {
            RequestBody body = RequestBody.create(text, object.toString());
            final Request request = new Request.Builder().url(host+url).post(body).build();
            client.newCall(request).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    System.out.println(e);
                }

                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    callback.callback(response.body().string());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
