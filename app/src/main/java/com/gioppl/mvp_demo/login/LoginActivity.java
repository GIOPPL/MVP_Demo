package com.gioppl.mvp_demo.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gioppl.mvp_demo.R;
import com.gioppl.mvp_demo.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginPresenter,ILogin.VP> {
    private EditText etName;
    private EditText etPwd;
    private Button btnLogin;

    @Override
    public ILogin.VP getContract() {
        return new ILogin.VP() {
            @Override
            public void requestLogin(String name, String pwd) throws Exception {
                mPresenter.getContract().requestLogin(name,pwd);
            }

            @Override
            public void responseResult(boolean loginStatusResult) {
                Toast.makeText(LoginActivity.this,loginStatusResult?"登陆成功":"登陆失败",Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        etName=findViewById(R.id.et_name);
        etPwd=findViewById(R.id.et_pwd);
        btnLogin=findViewById(R.id.btn_login);
    }

    @Override
    public void initListener() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public int getContextViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void destroy() {

    }

    @Override
    public LoginPresenter getPresenterInstance() {
        return new LoginPresenter();
    }

    @Override
    public <ERROR> void responseError(ERROR error,Throwable throwable) {
        Toast.makeText(this,""+error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        String name=etName.getText().toString();
        String pwd=etPwd.getText().toString();
        try {
            //面向接口
            getContract().requestLogin(name,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
