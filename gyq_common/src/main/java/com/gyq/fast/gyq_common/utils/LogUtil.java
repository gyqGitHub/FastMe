package com.gyq.fast.gyq_common.utils;

import com.gyq.fast.gyq_common.configure.BaseApplication;
import com.orhanobut.logger.Logger;

import org.json.JSONObject;

/**
 * 日志打印工具类
 *
 * @author Created by gyq on 2018/2/26.
 * @see BaseApplication
 * @since 1.0
 */
public class LogUtil {
    
    /**
     * 可以打印字符串，集合，数组
     */
    public static void d (Object message){
        Logger.d(message);
    }

    public static void e (String message){
        Logger.e(message);
    }

    public static void i (String message){
        Logger.i(message);
    }

    public static void wtf (String message){
        Logger.wtf(message);
    }

    public static void json (String jsonString){
        Logger.json(jsonString);
    }

    public static void xml (String xmlString){
        Logger.xml(xmlString);
    }

}
