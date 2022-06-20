package com.meishe.msvideoanalysis

import android.widget.Toast


/**
 * * All rights reserved,Designed by www.meishesdk.com
 * @Author : lpf
 * @CreateDate : 2022/6/20 下午3:52
 * @Description :
 * @Copyright :www.meishesdk.com Inc.All rights reserved.
 */
fun String.showToast(){
    Toast.makeText(App.getContext(),this,Toast.LENGTH_LONG).show();
}