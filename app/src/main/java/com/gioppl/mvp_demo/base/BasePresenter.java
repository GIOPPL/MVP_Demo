package com.gioppl.mvp_demo.base;

public abstract class BasePresenter <M extends BaseModel,V extends BaseActivity,CONTRACT> extends SuperBase <CONTRACT>{
    public V mView;
    public M mModel;
    public BasePresenter(){
        this.mModel=getModelInstance();
    }
    public void bindView(V mView){
        this.mView=mView;
    }
    public void unBindView(){
        this.mView=null;
    }
    public abstract M getModelInstance();
}
