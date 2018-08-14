package com.example.administrator.textmvp.ui.module.contract;

import com.example.administrator.textmvp.base.BasePresenter;
import com.example.administrator.textmvp.base.BaseView;

/**
 * Created by Administrator on 2018/8/14.
 */

public class RetrofitContract {
public interface  View extends BaseView{}

    public interface Presenter {
    void  getlist();
    }
}
