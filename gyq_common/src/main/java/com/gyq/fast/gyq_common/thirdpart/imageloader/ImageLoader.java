package com.gyq.fast.gyq_common.thirdpart.imageloader;

import android.content.Context;
import android.widget.ImageView;



/**
*
*图片加载类 Glide
*@author Created by gyq on 2018/4/28.
*@see 
*@since 
*/
public class ImageLoader {

    public static void loadImage(Context context, String url, ImageView imageView){
        GlideApp.with(context).load(url).into(imageView);
    }

    public static void loadCircleImage(Context context, String url, ImageView imageView) {
        GlideApp.with(context).load(url).circleCrop().into(imageView);
    }
}
