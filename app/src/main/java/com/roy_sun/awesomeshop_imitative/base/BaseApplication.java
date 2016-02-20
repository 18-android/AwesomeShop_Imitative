package com.roy_sun.awesomeshop_imitative.base;

import android.app.Application;

import com.roy_sun.awesomeshop_imitative.utils.UIUtils;

/**
 * application创建时加载的工具
 * Created by Roy_Sun on 2016/2/17 0017.
 */
public class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        UIUtils.init(this);
    }

}
