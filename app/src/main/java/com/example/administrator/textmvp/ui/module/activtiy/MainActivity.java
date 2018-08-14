package com.example.administrator.textmvp.ui.module.activtiy;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.textmvp.R;
import com.example.administrator.textmvp.app.App;
import com.example.administrator.textmvp.model.entity.DaoBeans;
import com.example.administrator.textmvp.model.entity.HomeBeans;
import com.example.administrator.textmvp.model.http.HttpFactory;
import com.example.administrator.textmvp.ui.module.adapter.HomeAdapter;
import com.example.administrator.textmvp.ui.module.contract.HomeContract;
import com.example.administrator.textmvp.ui.module.presenter.HomePresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeContract.View {

    private ListView lv;
    private HomeContract.Presenter homePresenter;
@SuppressLint("HandlerLeak")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        homePresenter = new HomePresenter();
        homePresenter.attach(this);
        homePresenter.getNewsList();
    }

    @Override
    public void showNewsList(HomeBeans beans) {
        List<HomeBeans.ResultsBean> results = beans.getResults();
        for (int i = 0; i < results.size(); i++) {
            addDao(results.get(i).getUrl());
        }
        HomeAdapter adapter = new HomeAdapter(MainActivity.this, results);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toDetailView();
            }
        });
        Toast.makeText(this, results.get(0).getUrl(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toDetailView() {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    @Override
    public void addDao(String url) {
        DaoBeans daoBeans = new DaoBeans();
        daoBeans.setImgurl(url);
       HttpFactory.createdao().getDaoSession().getDaoBeansDao().insert(daoBeans);
    }


    @Override
    public void initView() {
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.decath();
    }
}
