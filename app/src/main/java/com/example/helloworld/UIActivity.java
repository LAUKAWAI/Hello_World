package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.CompoundButton.*;

public class UIActivity<java, sql> extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, RatingBar.OnRatingBarChangeListener {
    private TextView mTextView;
    private Button mButtonLeft, mButtonRight, mButtonOk;
    private Switch mSwitch;
    private ProgressBar mProgressBar;
    private EditText mEditTextNumber;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonAndroid, mRadioButtonApple, mRadioButtonAli;
    private ImageView mImageView;
    private SeekBar mSeekBar;
    private CheckBox mCheckAndroid, mCheckJava, mCheckSql;
    private RatingBar mRatingBar;
    private String android = "", java = "", sql = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_i);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉Activity上面的状态栏

        mTextView = findViewById(R.id.textView);
        mButtonLeft = findViewById(R.id.button_left);
        mSwitch = findViewById(R.id.buttom_swith);
        mEditTextNumber = findViewById(R.id.edit_number);
        mButtonOk = findViewById(R.id.button_ok);
        mProgressBar = findViewById(R.id.progress_Bar);
        mRadioGroup = findViewById(R.id.radio_group);
        mImageView = findViewById(R.id.image_view);
        mRadioButtonAndroid = findViewById(R.id.radio_android);
        mRadioButtonApple = findViewById(R.id.radio_apple);
        mRadioButtonAli = findViewById(R.id.radio_all);
        mSeekBar = findViewById(R.id.seek_bar);
        mCheckAndroid = findViewById(R.id.check_android);
        mCheckJava = findViewById(R.id.check_java);
        mCheckSql = findViewById(R.id.check_sql);
        mRatingBar = findViewById(R.id.rating_bar);
        mButtonRight = findViewById(R.id.button_right);

        mButtonLeft.setOnClickListener(this);
        mButtonRight.setOnClickListener(this);
        mSwitch.setOnCheckedChangeListener(this);
        mButtonOk.setOnClickListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
        mSeekBar.setOnSeekBarChangeListener(this);
        mCheckAndroid.setOnCheckedChangeListener(this);
        mCheckJava.setOnCheckedChangeListener(this);
        mCheckSql.setOnCheckedChangeListener(this);
        mRatingBar.setOnRatingBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_left:
                mTextView.setText(getResources().getString(R.string.button_left));
                break;
            case R.id.button_right:
                mTextView.setText(getResources().getString(R.string.button_right));
                break;
            case R.id.button_ok:
                //String s = mEditTextNumber.getText().toString();//获取编辑框中的字符串
                // int a = Integer.parseInt(s);//转换为整数数字
                // mProgressBar.setProgress(a);//设置进度
                // mProgressBar.setProgress(Integer.parseInt(mEditTextNumber.getText().toString()));
                int temp;
                try {
                    temp = Integer.parseInt(mEditTextNumber.getText().toString());
                } catch (NumberFormatException e) {
                    temp = 100;
                }

                mProgressBar.setProgress(temp);//设置进度
                mSeekBar.setProgress(temp);
                if (temp <= 30) {
                    mRadioButtonAndroid.setChecked(true);
                } else if (temp <= 60) {
                    mRadioButtonApple.setChecked(true);
                } else {
                    mRadioButtonAli.setChecked(true);
                }

            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.buttom_swith:
                mTextView.setText(isChecked ? getString(R.string.open) : getResources().getString(R.string.close));
                break;
            case R.id.check_android:
                if (isChecked) {
                    android = getResources().getString(R.string.android);
                } else {
                    android = "";
                }
                mTextView.setText(android + java + sql);
                break;
            case R.id.check_java:
                if (isChecked) {
                    java = getResources().getString(R.string.java);
                } else {
                    java = "";
                }
                mTextView.setText(android + java + sql);
                break;
            case R.id.check_sql:
                if (isChecked) {
                    sql = getResources().getString(R.string.sql);
                } else {
                    sql = "";
                }
                mTextView.setText(android + java + sql);
                break;
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_android:
                mImageView.setImageResource(R.drawable.android);
                break;
            case R.id.radio_apple:
                mImageView.setImageResource(R.drawable.apple);
                break;
            case R.id.radio_all:
                mImageView.setImageResource(R.drawable.ia_100000018);
            default:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //当进度发生变化时调用该方法
        mTextView.setText(String.valueOf(progress));
        mEditTextNumber.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //当开始触摸该控件时发生
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //当结束触摸该控件时发生
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

        Toast.makeText(getApplicationContext(), rating + getResources().getString(R.string.appraize), Toast.LENGTH_SHORT).show();
    }
}
