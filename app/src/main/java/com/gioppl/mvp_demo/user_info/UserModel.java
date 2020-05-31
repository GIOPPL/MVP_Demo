package com.gioppl.mvp_demo.user_info;

import com.gioppl.mvp_demo.base.BaseModel;
import com.gioppl.mvp_demo.bean.ErrorInfoBean;
import com.gioppl.mvp_demo.bean.UserBean;

public class UserModel extends BaseModel<UserInfoPresenter,IUserInfo.M> {
    public UserModel(UserInfoPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IUserInfo.M getContract() {
        return new IUserInfo.M() {
            @Override
            public void requestUserInfo(String user) {
                if (user.equals("123")){
                    mPresenter.getContract().responseResult(new UserBean("普京","俄罗斯",50),null);
                }else if (user.equals("111")){
                    mPresenter.getContract().responseResult(new UserBean("特朗普","美国",55),null);
                }else {
                    mPresenter.getContract().responseResult(null,new ErrorInfoBean(-1,"未知错误"));
                }

            }
        };
    }
}
