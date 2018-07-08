package com.rid.morgan.inter.ibuy.sign;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import com.rid.morgan.inter.delegate.InterDelegate;
import com.rid.morgan.inter.ibuy.R;
import com.rid.morgan.inter.ibuy.R2;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Create by Morgan on 2018/7/8 0008
 */
public class SignInDelegate extends InterDelegate{

    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    @OnClick({R2.id.btn_sign_in})
    void onClickButton(){
        if(checkForm()){

        }
    }

    @OnClick({R2.id.icon_sign_in_wechat})
    void onClickWeChat(){

    }

    @OnClick (R2.id.tv_link_sign_up)
    void onClickLink(){
        start(new SignUpDelegate());
    }


    private boolean checkForm() {
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onUnBindView() {

    }

}
