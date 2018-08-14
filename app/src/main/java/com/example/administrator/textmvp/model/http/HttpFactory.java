package com.example.administrator.textmvp.model.http;

import com.example.administrator.textmvp.app.App;
import com.example.administrator.textmvp.gen.DaoSession;
import com.example.administrator.textmvp.model.db.DaoUtil;
import com.example.administrator.textmvp.model.db.IDao;

/**
 * Created by Administrator on 2018/8/13.
 */

public class HttpFactory {
    public static IHttp create(){
        return OkHttpUtils.getInstance();
    }
    public static DaoUtil createdao(){
        return DaoUtil.getInstance();
    }
}
