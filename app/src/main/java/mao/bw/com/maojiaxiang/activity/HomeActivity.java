package mao.bw.com.maojiaxiang.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import mao.bw.com.maojiaxiang.R;

public class HomeActivity extends AppCompatActivity {

    private ImageView img;
    private TextView name;
    private TextView pwd1;
    private SharedPreferences sp;
    private String url="http://172.17.8.100/images/small/head_pic/2019-06-10/20190610214625.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        img = findViewById(R.id.img);
        name = findViewById(R.id.name);
        pwd1 = findViewById(R.id.pwd);

        sp = getSharedPreferences("Login", Context.MODE_PRIVATE);
        String phone = sp.getString("phone", "");
        String pwd = sp.getString("pwd", "");
        name.setText(phone);
        pwd1.setText(pwd);
    //占位图
        Glide.with(this).load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.login)
                .into(img);


        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("上传头像")
                .setMessage("拍照上传")
                .setMessage("本地上传")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();
        alertDialog.show();
    }
}
