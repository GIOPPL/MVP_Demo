package com.gioppl.mvp_demo.login;

import com.gioppl.mvp_demo.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginModel,LoginActivity,ILogin.VP> {

    @Override
    public LoginModel getModelInstance() {
        return new LoginModel(this);
    }

    @Override
    public ILogin.VP getContract() {
        return new ILogin.VP() {
            @Override
            public void requestLogin(String name, String pwd) throws Exception {
                mModel.getContract().requestLogin(name, pwd);
            }

            @Override
            public void responseResult(boolean loginStatusResult) {
                mView.getContract().responseResult(loginStatusResult);
            }
        };
    }

//    @Override
//    public void requestLogin(String name, String pwd) throws Exception {
//        //校验请求的信息，进行逻辑处理
//        mModel.requestLogin(name, pwd);
//
//    }
//
//    @Override
//    public void responseResult(boolean loginStatusResult) {
//        //解析数据
//        mView.responseResult(loginStatusResult);
//    }
}
