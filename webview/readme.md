# Android与WebView的js交互
## 使用场景

## 常见功能开发
1. VebView调用Java方法
- 允许WebView加载js
> webView.getSettings().getJavaScriptEnabled(true);
- 编写js接口类
- 给WebView添加js接口
> webView.addJavascriptInterface(obj,name);

2. Android调用js的方法
- 使用loadUrl方法调用JavaScript
> webview.loadUrl(javascript:jsString);// jsString是要调用的js代码的字符串

3. 调试
- 打开允许调试的开关
> webview.setWebContentsDebuggingEnabled(true);// API 19及以上才可使用
- 使用Chrome浏览器进行调试
> chrome://inspect/#devices

## 常见问题
