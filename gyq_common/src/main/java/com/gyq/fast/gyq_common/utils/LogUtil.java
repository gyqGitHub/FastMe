package com.gyq.fast.gyq_common.utils;

import com.gyq.fast.gyq_common.configure.CommonBaseApplication;
import com.orhanobut.logger.Logger;

/**
 * 日志打印工具类
 *
 * @author Created by gyq on 2018/2/26.
 * @see CommonBaseApplication
 * @since 1.0
 */
public class LogUtil {

    /**
     * 可以打印字符串，集合，数组
     */
    public static void d(Object message) {
        if (CommonBaseApplication.isDebug()) {
            Logger.d(message);
        }
    }

    public static void e(String message) {
        if (CommonBaseApplication.isDebug()) {
            Logger.e(message);
        }
    }

    public static void i(String message) {
        if (CommonBaseApplication.isDebug()) {
            Logger.i(message);
        }
    }

    public static void wtf(String message) {
        if (CommonBaseApplication.isDebug()) {
            Logger.wtf(message);
        }
    }

    public static void json(String jsonString) {
        if (CommonBaseApplication.isDebug()) {
            Logger.json(jsonString);
        }
    }

    public static void xml(String xmlString) {

        if (CommonBaseApplication.isDebug()) {
            Logger.xml(xmlString);
        }
    }

}
