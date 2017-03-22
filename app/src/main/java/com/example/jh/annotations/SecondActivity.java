package com.example.jh.annotations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.EProvider;
import org.androidannotations.annotations.EReceiver;
import org.androidannotations.annotations.EService;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

/**
 * 作者：jinhui on 2017/3/22
 * 邮箱：1004260403@qq.com
 */
@EActivity(R.layout.second)
public class SecondActivity extends AppCompatActivity {

    @Extra(MainActivity.name)
    String name;
    @Extra(MainActivity.age)
    String age;
    @ViewById(R.id.textView1)
    TextView tv_name;
    @ViewById(R.id.textView2)
    TextView tv_age;

    @AfterViews
    public void setText(){
        tv_name.setText(name);
        tv_age.setText(age);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.second);
    }
}
