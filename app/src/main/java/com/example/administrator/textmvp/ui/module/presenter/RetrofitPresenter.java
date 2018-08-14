package com.example.administrator.textmvp.ui.module.presenter;

import android.util.Log;

import com.example.administrator.textmvp.model.biz.WorkService;
import com.example.administrator.textmvp.model.entity.HomeBeans;
import com.example.administrator.textmvp.model.http.RetrofitUtils;
import com.example.administrator.textmvp.ui.module.contract.RetrofitContract;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/8/14.
 */

public class RetrofitPresenter implements RetrofitContract.Presenter {
    private RetrofitContract.View mview;
    private WorkService workService;

    public RetrofitPresenter() {
        workService = RetrofitUtils.getWorkService();
    }

    @Override
    public void getlist() {
        workService
                .getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeBeans>() {
                    @Override
                    public void call(HomeBeans beans) {
                        mview.showList(beans);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                         Log.e("11111111111111",throwable.getMessage());
                    }
                });
    }

    @Override
    public void attach(RetrofitContract.View view) {
        this.mview = view;
    }

    @Override
    public void decath() {
        this.mview = null;
    }
}
