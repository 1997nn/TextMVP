package com.example.administrator.textmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2018/8/14.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public T presenter;
    private BaseFragment lastFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getViewId());
        parsePresenter();
        presenter.attach(this);
        initView();
        initData();


    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getViewId();
    private void parsePresenter(){
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        //获得第一个实现类中所有泛型参数的集合
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        //获得实现接口中第一个泛型的参数
        Class<T> tClass = (Class<T>) actualTypeArguments[0];
        try {
            //通过Java的动态代理来创建对象
            presenter = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.decath();
    }
    public void changeFragment(int containerId, Class<? extends BaseFragment> fragmentClass, Bundle bundle,boolean isReplace,boolean isBack){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //获取Fragment类的名字
        String simpleName = fragmentClass.getSimpleName();
        //根据tag值查找fragment
        BaseFragment fragment = (BaseFragment) fragmentManager.findFragmentByTag(simpleName);
        //fragment等于null的时候创建 添加
        if(fragment == null){
            try {
                fragment = fragmentClass.newInstance();
                transaction.add(containerId,fragment,simpleName);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //如果bundle不为null就传递参数
        if(bundle != null) {
            fragment.setBundle(bundle);
        }
        //将有上一个的fragment的时候隐藏上一个fragment
        if (lastFragment != null) {
            transaction.hide(lastFragment);
        }


        //isReplace为true则替换 false则隐藏显示
        if(isReplace){
            transaction.replace(containerId,fragment,simpleName);
        }else {
            //显示当前Fragment
            transaction.show(fragment);
        }

        //是否添加到回退栈
        if(isBack) {
            transaction.addToBackStack(simpleName);
        }
        //将在fragment显示完后 复值给上一个fragment
        lastFragment = fragment;

        transaction.commit();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        FragmentManager manager = getSupportFragmentManager();
        //获取栈中的数
        int entryCount = manager.getBackStackEntryCount();
        if (entryCount>0){
            manager.popBackStackImmediate();
        }
        int count = manager.getBackStackEntryCount();
        if (count>0){
            FragmentManager.BackStackEntry backStackEntryAt = manager.getBackStackEntryAt(count - 1);
            String name = backStackEntryAt.getName();
            BaseFragment fragment = (BaseFragment) manager.findFragmentByTag(name);
            lastFragment=fragment;
        }
    }
}
