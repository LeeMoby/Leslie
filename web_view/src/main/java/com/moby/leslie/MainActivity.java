package com.moby.leslie;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Web View
    private String url = "http://mobynote.com";
    private WebView wv_webview;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Web View
//        Uri uri = Uri.parse(url);
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);
        initActivity();

    }

    private void initActivity() {
        wv_webview = (WebView) findViewById(R.id.wv_webview);
        // WebView 加载本地文件
        //wv_webview.loadUrl("file:///android_asset/example.html");
        // WebView 加载网络地址
        wv_webview.loadUrl(url);
        // WebView 更改默认打开方式
        wv_webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                /**
                 * true:在WebView中打开
                 * false:调用系统浏览器打开
                 */
                view.loadUrl(url);
                return true;
            }
        });
        // WebView 启用JavaScript
        WebSettings settings = wv_webview.getSettings();
        settings.setJavaScriptEnabled(true);
        // WebView加载页面优先使用缓存加载
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        wv_webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
//                super.onProgressChanged(view, newProgress);
                //newProgress 1-100之间的整数
                if (newProgress == 100) {
                    // 页面加载完成
                    closeDialog();
                } else {
                    // 页面正在加载
                    openDialog(newProgress);
                }
            }
        });

    }

    private void openDialog(int newProgress) {
        if (dialog == null){
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("正在加载");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setProgress(newProgress);
            dialog.show();
        }else{
            dialog.setProgress(newProgress);
        }
    }

    private void closeDialog() {
        if(dialog != null && dialog.isShowing()){
            dialog.dismiss();
            dialog = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * 改写物理按键--返回的逻辑
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            // Toast.makeText(this, wv_webview.getUrl(), Toast.LENGTH_SHORT).show();
            if (wv_webview.canGoBack()){
                wv_webview.goBack();//返回上一页
                return true;
            }else{
                System.exit(0);//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
