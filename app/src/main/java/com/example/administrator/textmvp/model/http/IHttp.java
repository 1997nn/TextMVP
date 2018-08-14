package com.example.administrator.textmvp.model.http;

import com.example.administrator.textmvp.model.callback.NetworkCallback;

import java.util.Map;

/**
 * Created by Administrator on 2018/8/13.
 */

public interface IHttp {
    /**
     * 无参的get请求
     * @param url  接口地址
     * @param callback  接口回调
     * @param <T>泛型
     */
    <T> void doGet(String url, NetworkCallback<T> callback);


}
