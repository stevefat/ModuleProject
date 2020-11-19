package com.ngh.moduleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ngh.arouter_annotation.ARouter;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = BuildConfig.SERVER_URL;
        Log.e(TAG, "服务器地址是: " + url);

        if (BuildConfig.isRelease) {
            Log.e(TAG, "这个是正式环境，其他的都是lib 方式");
        } else {
            Log.e(TAG, "这个是测试环境，其他的都可以独自运行");
        }

    }
}