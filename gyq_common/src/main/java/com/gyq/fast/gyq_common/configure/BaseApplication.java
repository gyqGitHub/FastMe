package com.gyq.fast.gyq_common.configure;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.gyq.fast.gyq_common.BuildConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局对象初始化，环境配置
 *
 * @author Created by gyq on 2018/2/7.
 * @since 1.0
 */

public class BaseApplication extends Application {
    private static final String TAG = "BaseApplication";

    private static BaseApplication mInstance;
    public List<Activity> undestroyActivities;


    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        undestroyActivities = new ArrayList<>();

        initLogger();
    }


    public static BaseApplication getBaseApplication() {
        return mInstance;
    }

    public void addActivity(Activity activity) {
        undestroyActivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        undestroyActivities.remove(activity);
    }

    /**
     * 未销毁activity中是否包含clzz
     */
    public boolean isContainActivity(Class clzz) {
        for (Activity activity : undestroyActivities) {
            if (activity.getClass() == clzz) {
                return true;
            }
        }
        return false;
    }

    /**
     * 退出登录后需finsh所有activity
     */
    public void finishAllActivity() {
        for (Activity activity : undestroyActivities) {
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /**
     * finish指定activity
     *
     * @param clzz
     */
    public void finishActivity(Class clzz) {
        for (Activity activity : undestroyActivities) {
            if (activity.getClass() == clzz) {
                activity.finish();
            }
        }
    }

    /**
     * 判断Activity任务栈中是否包含指定的Activity
     *
     * @param clzz 目标Activity
     * @return -1，当app被系统回收后任务栈只包含前台Acitivty,状态不明
     * <p>0，任务栈中不包含指定Activity
     * <p>1，任务栈中包含指定Activity
     */
    public int containsActivity(Class clzz) {
        if (undestroyActivities.size() <= 1) {
            return -1;
        }

        for (Activity activity : undestroyActivities) {
            if (activity.getClass() == clzz) {
                return 1;
            }
        }

        return 0;
    }
    
    /**
     * 初始化 Logger 配置
     *
     *@author gyq
     *@see "https://github.com/orhanobut/logger"
     *@since 1.0
     */
    private void  initLogger (){
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // 是否显示线程信息. Default true
                .methodCount(3)         // (Optional) How many method line to show. Default 2
                .methodOffset(0)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("gyq_fast")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy){
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;// TODO: 2018/2/26 上线时需改为 false
            }
        });
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //1.及时释放不用的内存，如图片缓存，数据文件缓存等 2.动态生成 & 添加的View
    }

    /**
     * 注册监听 Activity 生命周期
     * 在每个 Activity 创建时需要进行的操作，比如 Stack<Activity> 管理
     *
     * @see Application
     * @since 1.0
     */
    private void registActivityLifecycle() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Log.e(TAG, "onActivityCreated: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.e(TAG, "onActivityStarted: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.e(TAG, "onActivityResumed: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.e(TAG, "onActivityPaused: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.e(TAG, "onActivityStopped: " + activity.getLocalClassName());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                Log.e(TAG, "onActivitySaveInstanceState: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.e(TAG, "onActivityDestroyed: " + activity.getLocalClassName());
            }
        });
    }
}
