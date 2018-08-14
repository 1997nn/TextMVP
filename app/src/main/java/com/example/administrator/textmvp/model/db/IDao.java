package com.example.administrator.textmvp.model.db;

import com.example.administrator.textmvp.gen.DaoBeansDao;
import com.example.administrator.textmvp.gen.DaoSession;
import com.example.administrator.textmvp.model.callback.NetworkCallback;
import com.example.administrator.textmvp.model.entity.DaoBeans;

import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */

public interface IDao {
     void loadall(DaoBeansDao dao, final NetworkCallback<List<DaoBeans>> callback);


}
