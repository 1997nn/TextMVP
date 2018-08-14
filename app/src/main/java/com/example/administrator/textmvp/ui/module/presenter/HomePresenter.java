package com.example.administrator.textmvp.ui.module.presenter;

import android.util.Log;

import com.example.administrator.textmvp.model.biz.HomeModel;
import com.example.administrator.textmvp.model.biz.IHomeModel;
import com.example.administrator.textmvp.model.callback.NetworkCallback;
import com.example.administrator.textmvp.model.entity.HomeBeans;
import com.example.administrator.textmvp.ui.module.contract.HomeContract;

/**
 * Created by Administrator on 2018/8/13.
 */

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View mview;
    private IHomeModel homeModel;

    public HomePresenter() {
        homeModel = new HomeModel();
    }

    @Override
    public void getNewsList() {
        homeModel.newsList(new NetworkCallback<HomeBeans>() {
            @Override
            public void onSuccess(HomeBeans beans) {
                if (mview != null) {
                    mview.showNewsList(beans);
                }
            }

            @Override
            public void onError(String error) {
                Log.e("111111111111",error);
            }
        });
    }

    @Override
    public void attach(HomeContract.View view) {
        this.mview = view;
    }

    @Override
    public void decath() {
        this.mview = null;
    }
}
