package com.example.administrator.textmvp.model.biz;

import com.example.administrator.textmvp.app.App;
import com.example.administrator.textmvp.config.content;
import com.example.administrator.textmvp.gen.DaoBeansDao;
import com.example.administrator.textmvp.model.callback.NetworkCallback;
import com.example.administrator.textmvp.model.db.IDao;
import com.example.administrator.textmvp.model.entity.DaoBeans;
import com.example.administrator.textmvp.model.entity.HomeBeans;
import com.example.administrator.textmvp.model.http.HttpFactory;

import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */

public class HomeModel implements IHomeModel{
    @Override
    public void newsList(NetworkCallback<HomeBeans> callback) {
        HttpFactory.create().doGet(content.STRING,callback);
    }

    @Override
    public void newsdao(NetworkCallback<List<DaoBeans>> callback) {

//        HttpFactory.createdao().loadall(HttpFactory.createdao().getDaoSession().getDaoBeansDao(),callback);
    }
}
