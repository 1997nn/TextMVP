package com.example.administrator.textmvp.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;

import com.example.administrator.textmvp.gen.DaoBeansDao;
import com.example.administrator.textmvp.gen.DaoMaster;
import com.example.administrator.textmvp.gen.DaoSession;
import com.example.administrator.textmvp.model.callback.NetworkCallback;
import com.example.administrator.textmvp.model.entity.DaoBeans;
import com.example.administrator.textmvp.utils.SUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */

public class App extends Application {
    public static Context context;

        @Override
        public void onCreate() {
            super.onCreate();
            SUtils.initialize(this);
            context=this;

        }


}
