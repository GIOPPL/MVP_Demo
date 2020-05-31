package com.gioppl.mvp_demo.login;

public interface ILogin {
    public interface M{
        void requestLogin(String name,String pwd)throws Exception;
    }

    public interface VP{
        void requestLogin(String name,String pwd)throws Exception;
        void responseResult(boolean loginStatusResult);
    }
}
