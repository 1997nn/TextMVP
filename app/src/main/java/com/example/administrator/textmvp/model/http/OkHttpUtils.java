package com.example.administrator.textmvp.model.http;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.example.administrator.textmvp.app.App;
import com.example.administrator.textmvp.model.callback.NetworkCallback;
import com.example.administrator.textmvp.utils.SUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/8/13.
 */

public class OkHttpUtils implements IHttp {
    private static OkHttpUtils okHttpUtils;
    private final OkHttpClient okHttpClient;

    private OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder().build();
    }

    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null)
                    okHttpUtils = new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }


    @Override
    public <T> void doGet(String url, final NetworkCallback<T> callback) {
        Request build = new Request.Builder().url(url).build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                final T t = parseData(result, callback);

                Handler mainHandler = new Handler(Looper.getMainLooper());
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //已在主线程中，可以更新UI
                        callback.onSuccess(t);
                    }
                });

            }
        });

    }

    private <T> T parseData(String string, NetworkCallback<T> callback) {
        Type[] types = callback.getClass().getGenericInterfaces();
        Type[] genericType2 = ((ParameterizedType) types[0]).getActualTypeArguments();
        Class<T> classes = (Class<T>) genericType2[0];
        Gson gson = new Gson();
        T t = gson.fromJson(string, classes);
        return t;
    }
}
