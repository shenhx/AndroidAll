package com.example.shenhx.webviewdemo;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class MyJsInterface {
    private static final String TAG = "MyJsInterface";

    // 因为跟主线程不在同一个线程中，所以需要利用连接桥
    private JsBridge jsBridge;

    public MyJsInterface(JsBridge jsBridge){
        this.jsBridge = jsBridge;
    }

    @JavascriptInterface
    public void setValue(String value){
        jsBridge.setTextViewValue(value);
        Log.d(TAG, "setValue: "+value);
    }
}
