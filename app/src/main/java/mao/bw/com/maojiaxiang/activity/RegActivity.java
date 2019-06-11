package mao.bw.com.maojiaxiang.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mao.bw.com.maojiaxiang.R;
import mao.bw.com.maojiaxiang.bean.Result;
import mao.bw.com.maojiaxiang.core.DataCall;
import mao.bw.com.maojiaxiang.presenter.RegPresenter;
/*
* 注册页面
* */
public class RegActivity extends AppCompatActivity implements DataCall<Result> {
    private EditText phone2;
    private EditText pwd2;
    private TextView text_login;
    private Button btn_register;
    private RegPresenter regPresenter;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        phone2 = findViewById(R.id.phone);
        pwd2 = findViewById(R.id.pwd);
        text_login = findViewById(R.id.text_login);
        btn_register = findViewById(R.id.btn_register);
        regPresenter = new RegPresenter(this);
        //跳转登录页面
        sp = getSharedPreferences("register", Context.MODE_PRIVATE);
        text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phone2.getText().toString();
                String pwd = pwd2.getText().toString();
                if (TextUtils.isEmpty(phone)||pwd.length()>6){
                    Toast.makeText(RegActivity.this,"输入框不能为空，且密码大于六位",Toast.LENGTH_SHORT).show();
                }else {
                    regPresenter.requestData(phone,pwd);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("phone",phone);
                    edit.putString("pwd",pwd);
                    edit.commit();
                }
            }
        });
    }


    @Override
    public void success(Result result, Object... args) {
        Intent intent =new Intent(RegActivity.this,MainActivity.class);
        sendBroadcast(intent);
        finish();
        Toast.makeText(RegActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
    }
}
