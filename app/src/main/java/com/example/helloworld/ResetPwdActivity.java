package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.databinding.ActivityResetPwdBinding;

/**
 * @author 86176
 */
public class ResetPwdActivity extends AppCompatActivity {
    private ActivityResetPwdBinding mBinding;
    String name, phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityResetPwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mBinding.editName.getText().toString().trim();
                phone = mBinding.editPhone.getText().toString().trim();
                String toast;
                if ("".equals(name)) {
                    toast = "请填写昵称";
                } else if ("".equals(phone)) {
                    toast = "请填写手机号码";
                } else if (phone.length() !=11) {
                    toast = "请正确输入要找回的中国大陆手机号码";
                } else {
                    SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                    //如果是0，就说明没有找到对应的信息
                    String error = "0";
                    String spName = sp.getString("name_" + phone, error);
                    String spPhone = sp.getString("phone_" + phone, error);
                    if (!spName.equals(name)||!spPhone.equals(phone))
                    {
                        toast = "很抱歉，未找到有关信息，请重新输入";
                    } else {
                        //跳转至修改密码界面
                        Intent intent = new Intent(ResetPwdActivity.this,UpdatePedActivity.class);
                        intent.putExtra("phone_",phone);
                        startActivity(intent);
                        toast = "请填写新密码";
                    }
                }
                Toast.makeText(ResetPwdActivity.this, toast, Toast.LENGTH_LONG).show();

            }
        });

    }
}
