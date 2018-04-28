package com.gyq.fast.fastme;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

/**
*前台服务
*@author Created by gyq on 2018/3/6.
*@see 
*@since 
*/

public class WeatherService extends Service {

    private static final int NOTIFY_ID = 123;

    @Override
    public void onCreate() {

        super.onCreate();

        showNotification();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void showNotification() {

        NotificationCompat.Builder mBuilder =

                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.sample_footer_loading_progress)

                        .setContentTitle("天气不错！！！！")

                        .setContentText("阳光明媚，是个好日子！");

        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);

        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        final Notification notification = mBuilder.build() ;


        mNotifyMgr.notify(NOTIFY_ID, notification);


        startForeground(NOTIFY_ID, notification);

    }

}




















