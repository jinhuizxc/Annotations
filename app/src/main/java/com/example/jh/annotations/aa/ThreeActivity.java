package com.example.jh.annotations.aa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jh.annotations.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：jinhui on 2017/3/22
 * 邮箱：1004260403@qq.com
 */

@EActivity(R.layout.three)
public class ThreeActivity extends AppCompatActivity {

    @ViewById(R.id.listView)
    ListView listView;


    // listView点击事件,可以设置长按监听。
    @ItemClick(R.id.listView)
    public void listItemClick(){
        Toast.makeText(this, "listView点击事件", Toast.LENGTH_SHORT).show();
    }
    //初始化数据
    @AfterViews
    public void init(){
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            data.add(String.valueOf(i));
        }
        MyAdapter adapter = new MyAdapter(data, this);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
