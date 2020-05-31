package com.gioppl.mvp_demo.user_info;

import com.gioppl.mvp_demo.base.BasePresenter;
import com.gioppl.mvp_demo.bean.ErrorInfoBean;
import com.gioppl.mvp_demo.bean.UserBean;

public class UserInfoPresenter extends BasePresenter<UserModel,MyInfoActivity,IUserInfo.VP> {

    @Override
    public UserModel getModelInstance() {
        return new UserModel(this);
    }

    @Override
    public IUserInfo.VP getContract() {
        return new IUserInfo.VP() {
            @Override
            public void requestUserInfo(String user) {
                mModel.getContract().requestUserInfo(user);
            }

            @Override
            public void responseResult(UserBean userBean, ErrorInfoBean error) {
                mView.getContract().responseResult(userBean,error);
            }
        };
    }
}
