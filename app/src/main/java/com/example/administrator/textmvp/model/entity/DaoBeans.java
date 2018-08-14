package com.example.administrator.textmvp.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/8/13.
 */
@Entity
public class DaoBeans {
    @Id(autoincrement = true)
    Long id;
    String imgurl;
    @Generated(hash = 1813163815)
    public DaoBeans(Long id, String imgurl) {
        this.id = id;
        this.imgurl = imgurl;
    }
    @Generated(hash = 379735705)
    public DaoBeans() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImgurl() {
        return this.imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
