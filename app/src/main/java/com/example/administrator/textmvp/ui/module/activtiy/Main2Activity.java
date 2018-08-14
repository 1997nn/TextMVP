package com.example.administrator.textmvp.ui.module.activtiy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.textmvp.R;
import com.example.administrator.textmvp.model.entity.DaoBeans;
import com.example.administrator.textmvp.ui.module.adapter.DaoAdapter;
import com.example.administrator.textmvp.ui.module.adapter.HomeAdapter;
import com.example.administrator.textmvp.ui.module.contract.DaoContract;
import com.example.administrator.textmvp.ui.module.presenter.DaoPresenter;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements DaoContract.View {

    private ListView lv;
    private DaoPresenter daoPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        daoPresenter = new DaoPresenter();
        daoPresenter.attach(this);
        daoPresenter.getDaoBeans();
    }

    @Override
    public void initView() {
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void shuodaobeans(List<DaoBeans> beans) {
        DaoAdapter daoAdapter = new DaoAdapter(this, beans);
        lv.setAdapter(daoAdapter);
        Toast.makeText(this, beans.get(1).getImgurl(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        daoPresenter.decath();
    }
}
