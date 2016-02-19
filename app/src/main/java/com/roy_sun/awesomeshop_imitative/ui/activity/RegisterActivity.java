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

public class RegisterActivity extends Activity implements View.OnClickListener {

    private ImageView mGo_next;
    private EditText mUsername;
    private EditText mUserpwd;
    private EditText mReuserpwd;
    private TextView mBtn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
    }

    private void init() {
        mGo_next = (ImageView) findViewById(R.id.register_go_next);
        mBtn_register = (TextView) findViewById(R.id.register_register);
        mUsername = (EditText) findViewById(R.id.register_username);
        mUserpwd = (EditText) findViewById(R.id.register_userpwd);
        mReuserpwd = (EditText) findViewById(R.id.register_reuserpwd);
        mGo_next.setOnClickListener(this);
        mBtn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_go_next:
                finish();
                break;
            case R.id.register_register:
                Register();
                break;
        }
    }

    /**
     * 注册
     */
    private void Register() {
        String userName = mUsername.getText().toString().trim();
        String userPwd = mUserpwd.getText().toString().trim();
        String userRePwd = mReuserpwd.getText().toString().trim();
        if (userName.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "用户名不能为空!", Toast.LENGTH_SHORT).show();
            return;
        } else if (userPwd.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "密码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        } else if (userRePwd.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "确认密码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        } else if (userPwd.equals(userRePwd)) {
            Toast.makeText(RegisterActivity.this, "两次密码输入不一致!", Toast.LENGTH_SHORT).show();
            return;
        }

        //实现注册 TODO
        //数据请求
    }
}
