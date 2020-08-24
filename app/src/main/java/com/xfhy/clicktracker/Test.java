package com.xfhy.clicktracker;

import android.util.Log;
import android.view.View;

import com.xfhy.library.FastClickUtil;

/**
 * @author : xfhy
 * Create time : 2020/8/24 11:00 PM
 * Description :
 */
public class Test {

    public void test(View view) {
        if (!FastClickUtil.shouldDoClick(view)) {
            return;
        }
        Log.d("xfhy777", "按钮2 点击事件");
    }

}
