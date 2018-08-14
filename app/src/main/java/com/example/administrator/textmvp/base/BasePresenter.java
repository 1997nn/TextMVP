package com.example.administrator.textmvp.base;

/**
 * Created by Administrator on 2018/8/13.
 */

public interface BasePresenter<V> {
    //生命周期方法
    void attach(V view);
    void decath();
}
