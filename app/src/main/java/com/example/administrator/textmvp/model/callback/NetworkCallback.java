package com.example.administrator.textmvp.model.callback;

/**
 * Created by Administrator on 2018/8/13.
 */

public interface NetworkCallback<T> {
    //成功的回调
    void onSuccess(T t);

    //异常的回调
    void onError(String error);
}
