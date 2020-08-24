package com.xfhy.clicktracker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xfhy.library.FastClickUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author : xfhy
 * Create time : 2020/8/23 10:51 PM
 * Description : Home
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnTest1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FastClickUtil.shouldDoClick(v)) {
                    Log.d("xfhy777", "按钮1 点击事件");
                }
            }
        });
        findViewById(R.id.btnTest2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (FastClickUtil.shouldDoClick(v)) {
            Log.d("xfhy777", "按钮2 点击事件");
        }
    }
}
