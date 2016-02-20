package com.roy_sun.awesomeshop_imitative.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.roy_sun.awesomeshop_imitative.R;

import okhttp3.internal.Util;

public class LoginActivity extends Activity implements View.OnClickListener {
    private TextView mLogin_register;
    private ImageView mGo_next;
    private EditText mUsername;
    private EditText mUserpwd;
    private TextView mBtn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        mLogin_register = (TextView) findViewById(R.id.login_register);
        mGo_next = (ImageView) findViewById(R.id.login_go_next);
        mBtn_login = (TextView) findViewById(R.id.login_btn_login);
        mUsername = (EditText) findViewById(R.id.login_username);
        mUserpwd = (EditText) findViewById(R.id.login_userpwd);
        mGo_next.setOnClickListener(this);
        mLogin_register.setOnClickListener(this);
        mBtn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_go_next:
                finish();
                break;
            case R.id.login_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.login_btn_login:
                login();
                break;
        }
    }

    /**
     * 登录
     */
    private void login() {

        String userName = mUsername.getText().toString().trim();
        String userPwd = mUserpwd.getText().toString().trim();
        if (userName.isEmpty()) {
            Toast.makeText(LoginActivity.this, "用户名不能为空!", Toast.LENGTH_SHORT).show();
            return;
        } else if (userPwd.isEmpty()) {
            Toast.makeText(LoginActivity.this, "密码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }

        //实现登录 TODO
        //数据请求
    }
}
