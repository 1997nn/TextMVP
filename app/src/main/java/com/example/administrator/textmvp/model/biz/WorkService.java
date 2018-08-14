package com.example.administrator.textmvp.model.biz;

import com.example.administrator.textmvp.model.entity.HomeBeans;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2018/8/14.
 */

public interface WorkService {
    @GET("data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<HomeBeans>  getHome();
}
