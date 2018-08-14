package com.example.administrator.textmvp.ui.module.presenter;

import com.example.administrator.textmvp.model.biz.HomeModel;
import com.example.administrator.textmvp.model.biz.IHomeModel;
import com.example.administrator.textmvp.model.callback.NetworkCallback;
import com.example.administrator.textmvp.model.entity.DaoBeans;
import com.example.administrator.textmvp.ui.module.contract.DaoContract;

import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */

public class DaoPresenter implements DaoContract.Presenter {
    private DaoContract.View mview;
    private IHomeModel homeModel;
public DaoPresenter(){
    homeModel=new HomeModel();
}
    @Override
    public void attach(DaoContract.View view) {
        this.mview = view;
    }

    @Override
    public void decath() {
        this.mview = null;
    }

    @Override
    public void getDaoBeans() {
        homeModel.newsdao(new NetworkCallback<List<DaoBeans>>() {

            @Override
            public void onSuccess(List<DaoBeans> daoBeans) {
                if (mview != null) {
                    mview.shuodaobeans(daoBeans);
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }

}
