package com.gyq.fast.gyq_common.base;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
*
*
*@author Created by gyq on 2018/4/28.
*@see 
*@since 
*/

public  class ActivityManager {

    private Stack<Activity> activityStack;

    private ActivityManager(){

    }

    private static class ActivityManagerHolder {
        private static final ActivityManager INSTANCE = new ActivityManager();

    }

    public static ActivityManager getInstance(){
        return ActivityManagerHolder.INSTANCE;
    }

    /**
     * 添加Activity
     * @param activity
     */
    public boolean addActivity(Activity activity){
        if(activityStack == null){
            activityStack = new Stack<>();
        }
        if(activity != null){
           return activityStack.add(activity);
        }
        return false;
    }

    /**
     * 移除Activity
     * @param activity
     */
    public boolean removeActivity(Activity activity){
        if(activity != null && activityStack != null){
           return activityStack.remove(activity);
        }
        return false;
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }


    /**
     * 未销毁activity中是否包含clazz
     * @param clazz
     * @return
     */
    public boolean contains(Class clazz) {
        for (Activity activity : activityStack) {
            if (activity.getClass() == clazz) {
                return true;
            }
        }
        return false;
    }


    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }



    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            // TODO: 2018/4/28 服务没有考虑到退出 /
            finishAllActivity();
            System.exit(0);
        } catch (Exception e) { }
    }


}
