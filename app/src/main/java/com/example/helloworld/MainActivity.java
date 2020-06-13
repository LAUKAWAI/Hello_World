package com.example.helloworld;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private static  final int RESULT_CODE =100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent:意图分为显示和隐式
                //new Intent的参数上下文，目标activity的类
                //默认手机号码10086，默认密码123456
                String phone = mBinding.editPhone.getText().toString();
                String pwd = mBinding.editPwd.getText().toString();
                SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                String temp_phone = sp.getString("phone_" + phone, "error");
                String temp_pwd = sp.getString("pwd_" + phone, "error");
                if (phone.equals(temp_phone) && pwd.equals(temp_pwd)) {
//                    Bundle bundle = new Bundle();
                    String userName = sp.getString("name_"+phone,"0");
                    String userSex = sp.getString("sex_"+phone,"0");
                    String userSms = "1".equals(sp.getString("sms_"+phone,"0")) ? "接受":"不接受";

                    //带有返回值的封装数据的activity的跳转
//                    UserInfo u = new UserInfo(userName,pwd,userSex,phone,userSms);
//                    bundle.putSerializable("userInfo",u);
//                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                    intent.putExtras(bundle);
//                    startActivityForResult(intent,RESULT_CODE);

                    //自定义的activity的跳转
                    HomeActivity.actionStart(MainActivity.this,userName,pwd,userSex,phone,userSms,RESULT_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "手机号码或密码错误", Toast.LENGTH_LONG).show();
                }
            }
        });
        //跳转注册界面
        mBinding.buttonRegisister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        //跳转忘记密码界面
        mBinding.textForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ResetPwdActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                String s = Objects.requireNonNull(data).getStringExtra(HomeActivity.EXIT_HOME);
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }
        }
    }
}
