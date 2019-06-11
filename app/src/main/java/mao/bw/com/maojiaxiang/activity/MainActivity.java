package mao.bw.com.maojiaxiang.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mao.bw.com.maojiaxiang.R;
import mao.bw.com.maojiaxiang.bean.LoginBean;
import mao.bw.com.maojiaxiang.core.DataCall;
import mao.bw.com.maojiaxiang.presenter.LoginPresenter;
/*
* 登录页面
* */
public class MainActivity extends AppCompatActivity implements DataCall<LoginBean> {
    private EditText phone1;
    private EditText pwd1;
    private TextView register;
    private Button btn_login;
    private CheckBox checkBox;
    private LoginPresenter loginPresenter;
    private SharedPreferences sp;
    private SharedPreferences register1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone1 = findViewById(R.id.phone);
        pwd1 = findViewById(R.id.pwd);
        register = findViewById(R.id.text_register);
        btn_login = findViewById(R.id.btn_login);
        checkBox = findViewById(R.id.checkbox);
        loginPresenter = new LoginPresenter(this);

     /*   register1 = getSharedPreferences("register", Context.MODE_PRIVATE);
        String phone2 = register1.getString("phone", "");
        String pwd2 = register1.getString("pwd", "");
        phone1.setText(phone2);
        pwd1.setText(pwd2);*/

        sp = getSharedPreferences("Login", Context.MODE_PRIVATE);
        if (sp.getBoolean("记住密码",false)){
            String phone = sp.getString("phone", "");
            String pwd = sp.getString("pwd", "");
            phone1.setText(phone);
            pwd1.setText(pwd);
            checkBox.setChecked(true);

        }
       //
        //跳转注册页面
        this.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,RegActivity.class);
                startActivity(intent);
            }
        });

        //登录按钮
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框的值
                String phone = phone1.getText().toString();
                String pwd = pwd1.getText().toString();
                if (TextUtils.isEmpty(phone)||TextUtils.isEmpty(pwd)){
                    Toast.makeText(MainActivity.this,"输入框不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    loginPresenter.requestData(phone,pwd);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("phone",phone);
                    edit.putString("pwd",pwd);
                    edit.putBoolean("记住密码",checkBox.isChecked());
                    edit.commit();
                }
            }
        });
    }

    @Override
    public void success(LoginBean result, Object... args) {
        Intent intent =new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.deachView();
    }
}
