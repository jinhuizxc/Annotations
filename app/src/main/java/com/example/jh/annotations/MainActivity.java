package com.example.jh.annotations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.jh.annotations.aa.ThreeActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;
import org.androidannotations.annotations.res.DimensionRes;
import org.androidannotations.annotations.res.StringRes;

import java.util.List;

/**
 *本demo测试Android annotations的使用,适用于中小型项目。
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    public static final String name = "null";
    public static final String age = "null";
    private static final String TAG = "MainActivity";

    @ViewById(R.id.button)
    Button button;
    @ViewById(R.id.button1)
    Button button1;
    @ViewById(R.id.button2)
    Button button2;
    @ViewById(R.id.button3)
    Button button3;
    @ViewById(R.id.button4)
    Button button4;
    // 单个注解
    @ViewById(R.id.textView)
    TextView textView;

    // 配置字体大小、配置字符串____________textView2
    @StringRes(R.string.str)
    String str;
    @DimensionRes(R.dimen.text_size)
    float floatSize;
    @ViewById(R.id.textView2)
    TextView textView2;
    @ViewById(R.id.textView3)
    TextView textView3;
    // 多个控件注解
    @ViewsById({R.id.textView4, R.id.textView5})
    List<TextView> list;
    @AfterViews
    public void setTextView(){
        textView2.setText(str);
        textView2.setTextSize(floatSize);
        textView3.setText("android");
    }
    @AfterViews
    public void setTextView2(){
        for (TextView textView:list) {
            textView.setText("哈哈");
        }
    }
    //设置点击，可以单个可以多个点击,可以设置长按监听，测试起来很容易就不写了
    @LongClick({R.id.textView2, R.id.textView3})
    public void showToast(){
        Toast.makeText(this, "textView2", Toast.LENGTH_SHORT).show();
    }
    @Click(R.id.button)
    public void startActivity(){
        Intent intent = new Intent(MainActivity.this, SecondActivity_.class);
        // 传参
        intent.putExtra(name, "jack");
        intent.putExtra(age, "18");
        startActivity(intent);
    }
    @LongClick(R.id.button2)
    public void show(){
        Toast.makeText(this, "button2", Toast.LENGTH_SHORT).show();
    }
    @Click(R.id.button1)
    public void startService(){
        Intent intent = new Intent(MainActivity.this, MyService_.class);
        startService(intent);
    }
    @Click(R.id.button3)
    public void start(){
        Intent intent = new Intent(MainActivity.this, ThreeActivity_.class);
        startActivity(intent);
    }
    @Click(R.id.button4)
    public void aaa(){
      doSomething();
    }
    @Background     // 因为这个方法执行在子线程中可以替代new Thread(), 用于处理后台任务
    public void doSomething() {
        Log.e(TAG, "thread =" + Thread.currentThread().getId());//  239
        // 子线程中更新我们的ui
        updateUi();
    }

    @UiThread    // 本方法主线程中调用
    public void updateUi() {
        textView.setText("update ui");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate thread =" + Thread.currentThread().getId());//  1


    }
}
