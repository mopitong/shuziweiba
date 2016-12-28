package com.mpt.demo.utils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by mpt on 2016/12/28.
 *
 * eventbus封装类
 */

public class EventUtil {
    public static void register(Object object) {
        if (!EventBus.getDefault().isRegistered(object)) {
            EventBus.getDefault().register(object);
        }
    }

    public static void unregister(Object object) {
        if (EventBus.getDefault().isRegistered(object)) {
            EventBus.getDefault().unregister(object);
        }
    }

    public static void post(Object object) {
        EventBus.getDefault().post(object);
    }

}
