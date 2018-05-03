package com.gyq.fast.fastme;


import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.gyq.fast.gyq_common.base.CommonBaseActivity;
import com.gyq.fast.gyq_common.utils.ToastUtil;

import butterknife.BindView;


public class MainActivity extends CommonBaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.dl_main)
    DrawerLayout dlMain;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initView() {
        //改变图标和字体颜色
        ColorStateList csl1 = getResources().getColorStateList(R.color.index_color_status_list, getTheme());
        navigation.setItemTextColor(csl1);
        navigation.setItemIconTintList(csl1);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);//不设置的话一直是第一个处于被选状态，但是其他是可以被点击的
        switch (item.getItemId()){
            case R.id.action_index:
                ToastUtil.showLong("action_index");
                break;
            case R.id.action_message:
                ToastUtil.showLong("action_message");
                break;
            case R.id.action_my:
                ToastUtil.showLong("action_my");
                break;
            default:
                break;
        }
        return false;
    }
}
