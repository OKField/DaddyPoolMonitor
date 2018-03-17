package com.example.okudatakumi.test;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // text_view1： activity_main.xml の TextView の id
        //TextView textView = (TextView) findViewById(R.id.text_view);
        TextView textView = findViewById(R.id.textView2);
        // テキストを設定
        //textView.setText("Test TextView");
        textView.setText(R.string.text);

       // HttpResponsAsync httpResponsAsync = new HttpResponsAsync();
        //new HttpResponsAsync();
         //httpResponsAsync.setOnCallBack(new HttpResponsAsync.CallBackTask(){
         //@Override
            //public void CallBack(String result) {
            //super.CallBack(result);

         /// / ※１
         // resultにはdoInBackgroundの返り値が入ります。
         // ここからAsyncTask処理後の処理を記述します。
//                    Log.i("AsyncTaskCallback", "非同期処理が終了しました。");
            //              }
            //});
        //httpResponsAsync.execute();

        //>>Webページを表示してみる
        WebView myWebView = (WebView) findViewById(R.id.WebView);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://zny.daddy-pool.work/stats");
        //<<Webページを表示してみる

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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


}
