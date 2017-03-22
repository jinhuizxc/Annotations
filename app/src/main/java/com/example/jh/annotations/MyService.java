package com.example.jh.annotations;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import org.androidannotations.annotations.EService;

/**
 * 作者：jinhui on 2017/3/22
 * 邮箱：1004260403@qq.com
 */
@EService
public class MyService extends Service {

    private static final String TAG = "MyService";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "=========onStartCommand========");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
