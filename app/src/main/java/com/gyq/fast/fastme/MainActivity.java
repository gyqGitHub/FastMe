package com.gyq.fast.fastme;


import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gyq.fast.gyq_common.base.CommonBaseActivity;
import com.gyq.fast.gyq_common.thirdpart.imageloader.GlideApp;
import com.gyq.fast.gyq_common.utils.ToastUtil;

import butterknife.BindView;


public class MainActivity extends CommonBaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener , NavigationView.OnNavigationItemSelectedListener{
    private static final String TAG = "MainActivity";
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.dl_main)
    DrawerLayout dlMain;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.nv_left)
    NavigationView nvLeft;

    private ImageView headerImage;

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
        // 动态加 app:headerLayout="@layout/nav_header 不然会出现两个nav_header
        ViewGroup headerLayout = (ViewGroup) nvLeft.inflateHeaderView(R.layout.nav_header);
        headerImage = (ImageView) headerLayout.findViewById(R.id.headerImage);
        GlideApp.with(mContext).load(R.drawable.m1).circleCrop().into(headerImage);

        //改变图标和字体颜色
        ColorStateList csl1 = getResources().getColorStateList(R.color.index_color_status_list, getTheme());
        navigation.setItemTextColor(csl1);
        navigation.setItemIconTintList(csl1);

        navigation.setOnNavigationItemSelectedListener(this);
        nvLeft.setNavigationItemSelectedListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);//不设置的话一直是第一个处于被选状态，但是其他是可以被点击的
        switch (item.getItemId()) {
            case R.id.action_index:
                ToastUtil.showLong("首页");
                break;
            case R.id.action_message:
                ToastUtil.showLong("消息");
                break;
            case R.id.action_my:
                ToastUtil.showLong("我的");
                break;
            case R.id.action_find:
                ToastUtil.showLong("发现");
                break;
            case R.id.action_account_book:
                ToastUtil.showLong("账本");
                break;
            case R.id.action_collect:
                ToastUtil.showLong("收藏");
                break;
            case R.id.action_browse_record:
                ToastUtil.showLong("浏览记录");
                break;
            case R.id.action_about:
                ToastUtil.showLong("关于");
                break;
            default:
                break;
        }
        return false;
    }
}
