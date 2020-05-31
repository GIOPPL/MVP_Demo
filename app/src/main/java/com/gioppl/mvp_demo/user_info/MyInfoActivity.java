package com.gioppl.mvp_demo.user_info;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gioppl.mvp_demo.R;
import com.gioppl.mvp_demo.base.BaseActivity;
import com.gioppl.mvp_demo.bean.ErrorInfoBean;
import com.gioppl.mvp_demo.bean.UserBean;

public class MyInfoActivity extends BaseActivity<UserInfoPresenter,IUserInfo.VP> {
    private EditText et_nickName;
    private TextView tv_age;
    private TextView tv_address;
    private Button btn_getInfo;

    @Override
    public IUserInfo.VP getContract() {
        return new IUserInfo.VP() {
            @Override
            public void requestUserInfo(String user) {
                mPresenter.getContract().requestUserInfo(user);
            }

            @Override
            public void responseResult(UserBean userBean, ErrorInfoBean error) {
                if (error==null){
                    tv_age.setText(userBean.getNickName());
                    tv_address.setText(userBean.getAddress());
                }else {
                    Toast.makeText(MyInfoActivity.this,error.getCode()+":"+error.getMsg(),Toast.LENGTH_SHORT).show();
                }

            }
        };
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        et_nickName=findViewById(R.id.et_nickName);
        tv_age=findViewById(R.id.tv_age);
        tv_address=findViewById(R.id.tv_address);
        btn_getInfo=findViewById(R.id.btn_getInfo);
    }

    @Override
    public void initListener() {
        btn_getInfo.setOnClickListener(this);
    }

    @Override
    public int getContextViewId() {
        return R.layout.activity_imy_info;
    }

    @Override
    public void destroy() {

    }

    @Override
    public UserInfoPresenter getPresenterInstance() {
        return new UserInfoPresenter();
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btn_getInfo:
                getContract().requestUserInfo(et_nickName.getText().toString());
                break;
        }
    }
}
