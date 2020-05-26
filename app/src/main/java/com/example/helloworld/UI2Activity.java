package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
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

import com.example.helloworld.databinding.ActivityUI2Binding;

public class UI2Activity extends AppCompatActivity {

    private ActivityUI2Binding mBinding;
//    private TextView mTextView;
//    private Button mButtonLeft, mButtonRight, mButtonOk;
//    private Switch mSwitch;
//    private ProgressBar mProgressBar;
//    private EditText mEditTextNumber;
//    private RadioGroup mRadioGroup;
//    private RadioButton mRadioButtonAndroid, mRadioButtonApple, mRadioButtonAli;
//    private ImageView mImageView;
//    private SeekBar mSeekBar;
//    private CheckBox mCheckAndroid, mCheckJava, mCheckSql;
//    private RatingBar mRatingBar;
    private String android = "", java = "", sql = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityUI2Binding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

//        mTextView = findViewById(R.id.textView);
//        mButtonLeft = findViewById(R.id.button_left);
//        mSwitch = findViewById(R.id.buttom_swith);
//        mEditTextNumber = findViewById(R.id.edit_number);
//        mButtonOk = findViewById(R.id.button_ok);
//        mProgressBar = findViewById(R.id.progress_Bar);
//        mRadioGroup = findViewById(R.id.radio_group);
//        mImageView = findViewById(R.id.image_view);
//        mRadioButtonAndroid = findViewById(R.id.radio_android);
//        mRadioButtonApple = findViewById(R.id.radio_apple);
//        mRadioButtonAli = findViewById(R.id.radio_all);
//        mSeekBar = findViewById(R.id.seek_bar);
//        mCheckAndroid = findViewById(R.id.check_android);
//        mCheckJava = findViewById(R.id.check_java);
//        mCheckSql = findViewById(R.id.check_sql);
//        mRatingBar = findViewById(R.id.rating_bar);
//        mButtonRight = findViewById(R.id.button_right);


        mBinding.buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.textView.setText(getText(R.string.button_left));
            }
        });

        mBinding.buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.textView.setText(getText(R.string.button_right));
            }
        });

        mBinding.buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String s = mEditTextNumber.getText().toString();//获取编辑框中的字符串
                // int a = Integer.parseInt(s);//转换为整数数字
                // mProgressBar.setProgress(a);//设置进度
                // mProgressBar.setProgress(Integer.parseInt(mEditTextNumber.getText().toString()));
                int temp;
                try {
                    temp = Integer.parseInt(mBinding.editNumber.getText().toString());
                } catch (NumberFormatException e) {
                    temp = 100;
                }

                mBinding.progressBar.setProgress(temp);//设置进度
                mBinding.seekBar.setProgress(temp);
                if (temp <= 30) {
                    mBinding.radioAndroid.setChecked(true);
                } else if (temp <= 60) {
                    mBinding.radioApple.setChecked(true);
                } else {
                    mBinding.radioAll.setChecked(true);
                }
            }
        });

        mBinding.buttomSwith.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mBinding.textView.setText(isChecked ? getString(R.string.open) : getResources().getString(R.string.close));
            }
        });
        mBinding.checkAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    android = getResources().getString(R.string.android);
                } else {
                    android = "";
                }
                mBinding.textView.setText(android + java + sql);

            }
        });
        mBinding.checkJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    java = getResources().getString(R.string.java);
                } else {
                    java = "";
                }
                mBinding.textView.setText(android + java + sql);
            }
        });
        mBinding.checkSql.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sql = getResources().getString(R.string.sql);
                } else {
                    sql = "";
                }
                mBinding.textView.setText(android + java + sql);
            }
        });
        mBinding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_android:
                        mBinding.imageView.setImageResource(R.drawable.android);
                        break;
                    case R.id.radio_apple:
                        mBinding.imageView.setImageResource(R.drawable.apple);
                        break;
                    case R.id.radio_all:
                        mBinding.imageView.setImageResource(R.drawable.ia_100000018);
                    default:


                }}
        });
        mBinding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //当进度发生变化时调用该方法
                mBinding.textView.setText(String.valueOf(progress));
                mBinding.editNumber.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        mBinding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), rating + getResources().getString(R.string.appraize), Toast.LENGTH_SHORT).show();
            }
        });
}

    }
