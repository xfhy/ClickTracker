package com.xfhy.library;

import android.view.View;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author : xfhy
 * Create time : 2020/8/24 10:16 PM
 * Description : 快速点击工具类
 */
public class FastClickUtil {

    private static final long ANTI_SHAKE_TIME = 300L;
    private static final Map<View, Long> VIEW_WEAK_HASH_MAP = new WeakHashMap<>();

    public static boolean shouldDoClick(View targetView) {
        Long lastClickTime = VIEW_WEAK_HASH_MAP.get(targetView);
        long currentTimeMillis = System.currentTimeMillis();
        if (lastClickTime == null || currentTimeMillis - lastClickTime > ANTI_SHAKE_TIME) {
            VIEW_WEAK_HASH_MAP.put(targetView, currentTimeMillis);
            return true;
        }
        return false;
    }

}
