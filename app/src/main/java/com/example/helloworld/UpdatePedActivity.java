package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.databinding.ActivityUpdatePwdBinding;

/**
 * @author 86176
 */
public class UpdatePedActivity extends AppCompatActivity {

private ActivityUpdatePwdBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityUpdatePwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = mBinding.editPwd.getText().toString().trim();
                String pwd_ok = mBinding.editOkPwd.getText().toString().trim();

                if(!pwd.equals(pwd_ok)){
                    Toast.makeText(UpdatePedActivity.this,"密码输入不一致",Toast.LENGTH_LONG).show();
                }else if(pwd.length()!=6){
                    Toast.makeText(UpdatePedActivity.this,"密码只能是6位",Toast.LENGTH_LONG).show();
                } else{
                    SharedPreferences sp = getSharedPreferences("user_info",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    String phone = getIntent().getStringExtra("phone_");
                    editor.putString("pwd_"+phone,pwd).apply();
                    Intent intent = new Intent(UpdatePedActivity.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(UpdatePedActivity.this,"修改密码成功,请重新登录",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
