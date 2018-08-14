package com.example.administrator.textmvp.model.db;

import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.textmvp.app.App;
import com.example.administrator.textmvp.gen.DaoBeansDao;
import com.example.administrator.textmvp.gen.DaoMaster;
import com.example.administrator.textmvp.gen.DaoSession;
import com.example.administrator.textmvp.model.callback.NetworkCallback;
import com.example.administrator.textmvp.model.entity.DaoBeans;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */

public class DaoUtil implements IDao {
    private static DaoUtil daoUtil;
    private DaoSession daoSession;

    private DaoUtil() {
        createDataBase();
    }
    public static DaoUtil getInstance() {
       if (daoUtil==null){
           synchronized (DaoUtil.class){
               if (daoUtil==null){
                   daoUtil = new DaoUtil();
               }
           }
       }
        return daoUtil;
    }
    private void createDataBase() {
        //数据库对象的创建
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.context, "dao");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public  DaoSession getDaoSession() {
        return daoSession;
    }
//
    @Override
    public void loadall(DaoBeansDao dao, NetworkCallback<List<DaoBeans>> callback) {
        List<DaoBeans> daoBeans = dao.loadAll();
        callback.onSuccess(daoBeans);
    }

}
