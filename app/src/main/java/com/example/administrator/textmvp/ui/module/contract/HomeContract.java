package com.example.administrator.textmvp.ui.module.contract;

import com.example.administrator.textmvp.base.BasePresenter;
import com.example.administrator.textmvp.base.BaseView;
import com.example.administrator.textmvp.model.entity.HomeBeans;

/**
 * Created by Administrator on 2018/8/13.
 */

public interface HomeContract {
    interface View extends BaseView {
        void showNewsList(HomeBeans beans);
         void toDetailView();
         void addDao(String url);
    }
    interface Presenter extends BasePresenter<View> {
        void getNewsList();
    }
}
