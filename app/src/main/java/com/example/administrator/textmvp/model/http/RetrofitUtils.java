package com.example.administrator.textmvp.model.http;

import com.example.administrator.textmvp.model.biz.WorkService;

import retrofit2.Retrofit;

/**
 * Created by Administrator on 2018/8/14.
 */

public class RetrofitUtils {
    public static WorkService getWorkService() {
        return new Retrofit.Builder().baseUrl("http://gank.io/api/").build().create(WorkService.class);
    }
}
