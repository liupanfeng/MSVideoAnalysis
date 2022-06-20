package com.meishe.msvideoanalysis;

import android.app.Application;
import android.content.Context;

/**
 * * All rights reserved,Designed by www.meishesdk.com
 *
 * @Author : lpf
 * @CreateDate : 2022/6/20 下午3:53
 * @Description :
 * @Copyright :www.meishesdk.com Inc.All rights reserved.
 */
public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }

    public static Context getContext() {
        return mContext;
    }
}
