package com.example.jh.annotations.aa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 作者：jinhui on 2017/3/22
 * 邮箱：1004260403@qq.com
 */

public class MyAdapter extends BaseAdapter {

    private List<String> list;
    Context context;

    public MyAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String data = list.get(position);
        TextView text = new TextView(context);
        text.setText(data);

        return text;
    }
}
