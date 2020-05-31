package com.gioppl.mvp_demo.user_info;

import com.gioppl.mvp_demo.bean.ErrorInfoBean;
import com.gioppl.mvp_demo.bean.UserBean;

public interface IUserInfo {
    public interface M{
        void requestUserInfo(String user);
    }
    public interface VP{
        void requestUserInfo(String user);
        void responseResult(UserBean userBean, ErrorInfoBean error);
    }
}
