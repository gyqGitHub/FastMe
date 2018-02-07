package com.gyq.fast.gyq_common.configure;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by gyq on 2018/2/7.
 * 全局对象初始化，环境配置
 */

public class BaseApplication extends Application {
    private static final String TAG = "BaseApplication";
    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Log.e(TAG,"onActivityCreated: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.e(TAG,"onActivityStarted: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.e(TAG,"onActivityResumed: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.e(TAG,"onActivityPaused: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.e(TAG,"onActivityStopped: " + activity.getLocalClassName());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                Log.e(TAG,"onActivitySaveInstanceState: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.e(TAG,"onActivityDestroyed: " + activity.getLocalClassName());
            }
        });
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //1.及时释放不用的内存，如图片缓存，数据文件缓存等 2.动态生成 & 添加的View
    }
}
