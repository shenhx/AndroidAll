package com.example.shenhx.webviewdemo;

import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements JsBridge{

    private WebView mWebView;
    private TextView mTvResult;
    private EditText mEditText;
    private Button mBtn;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets(savedInstanceState);
    }

    private void  initWidgets(Bundle savedInstanceState){
        mWebView = findViewById(R.id.webview);
        mTvResult = findViewById(R.id.tv_result);
        mEditText = findViewById(R.id.editText);
        mBtn = findViewById(R.id.button);
        mHandler = new Handler();
        // 允许webview加载js
        mWebView.getSettings().setJavaScriptEnabled(true);

        // 给WebView添加js接口
        mWebView.addJavascriptInterface(new MyJsInterface(this),"myLauncher");

        mWebView.loadUrl("file:///android_asset/index.html");

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = mEditText.getText().toString();
                mWebView.loadUrl("javascript:if(window.remote){window.remote('"+str+"')}");
            }
        });

        // 允许chrome浏览器可以调试
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mWebView.setWebContentsDebuggingEnabled(true);
        }
    }

    @Override
    public void setTextViewValue(final String value) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mTvResult.setText(value);
            }
        });
        Log.d("TextViewResult", value);
    }
}
