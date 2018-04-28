package com.gyq.fast.gyq_common.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.gyq.fast.gyq_common.R;
import com.gyq.fast.gyq_common.configure.CommonBaseApplication;

/**
 * Activity 基类
 *
 * @author Created by gyq on 2018/2/9.
 * @see
 * @since 1.0
 */

public abstract class CommonBaseActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        if (null != getIntent()) {
            getDataFromIntent(getIntent());
        }

        setContentView(getContentViewId());


    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

    public abstract int getContentViewId();

    public abstract void initView();

    public abstract void initData();

    protected void startActivity(Class<?> clazz,Bundle bundle){
        if(mContext != null ){
            Intent intent = new Intent(mContext,clazz);
            if(bundle != null){
                intent.putExtras(bundle);
            }
            mContext.startActivity(intent);
        }
    }

    protected void getDataFromIntent(Intent intent) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
