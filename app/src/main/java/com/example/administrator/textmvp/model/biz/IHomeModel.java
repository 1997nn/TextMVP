package com.example.administrator.textmvp.model.biz;

import com.example.administrator.textmvp.model.callback.NetworkCallback;
import com.example.administrator.textmvp.model.entity.DaoBeans;
import com.example.administrator.textmvp.model.entity.HomeBeans;

import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */

public interface IHomeModel {
    void newsList(NetworkCallback<HomeBeans> callback);

    void newsdao(NetworkCallback<List<DaoBeans>> callback);
}
