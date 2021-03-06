package com.example.administrator.textmvp.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.administrator.textmvp.model.entity.DaoBeans;

import com.example.administrator.textmvp.gen.DaoBeansDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig daoBeansDaoConfig;

    private final DaoBeansDao daoBeansDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        daoBeansDaoConfig = daoConfigMap.get(DaoBeansDao.class).clone();
        daoBeansDaoConfig.initIdentityScope(type);

        daoBeansDao = new DaoBeansDao(daoBeansDaoConfig, this);

        registerDao(DaoBeans.class, daoBeansDao);
    }
    
    public void clear() {
        daoBeansDaoConfig.clearIdentityScope();
    }

    public DaoBeansDao getDaoBeansDao() {
        return daoBeansDao;
    }

}
