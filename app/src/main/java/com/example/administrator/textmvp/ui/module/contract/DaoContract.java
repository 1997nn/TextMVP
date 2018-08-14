package com.example.administrator.textmvp.ui.module.contract;

import com.example.administrator.textmvp.base.BasePresenter;
import com.example.administrator.textmvp.base.BaseView;
import com.example.administrator.textmvp.model.entity.DaoBeans;

import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */

public class DaoContract {
    public interface View extends BaseView{
        void shuodaobeans(List<DaoBeans> beans);
    }
    public interface Presenter extends BasePresenter<View>{
        void getDaoBeans();
    }
}
