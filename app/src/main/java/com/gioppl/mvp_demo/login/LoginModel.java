package com.gioppl.mvp_demo.login;

import com.gioppl.mvp_demo.base.BaseModel;

public class LoginModel extends BaseModel<LoginPresenter,ILogin.M> {

    public LoginModel(LoginPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public ILogin.M getContract() {
        return new ILogin.M() {
            @Override
            public void requestLogin(String name, String pwd) throws Exception {
                //请求服务器登陆接口，拿到服务器返回Json数据
                if ("abc".equals(name)&& "123".equals(pwd)){
                    mPresenter.getContract().responseResult(true);
                }else {
                    mPresenter.getContract().responseResult(false);
                }
            }
        };
    }
}
