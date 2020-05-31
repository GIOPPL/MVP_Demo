package com.gioppl.mvp_demo.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter,CONTRACT> extends AppCompatActivity implements View.OnClickListener {
    public abstract CONTRACT getContract();
    public P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContextViewId());
        initView();
        initData();
        initListener();
        mPresenter=getPresenterInstance();
        mPresenter.bindView(this);
    }
    public abstract void initData();
    public abstract void initView();
    public abstract void initListener();
    public abstract int getContextViewId();
    public abstract void destroy();
    public abstract P getPresenterInstance();

    @Override
    public void onClick(View v) {

    }
}
