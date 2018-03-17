package com.example.okudatakumi.test;


import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by  on 2018/03/12.
 */

public class HttpResponsAsync extends AsyncTask<String, Void, String> {
    //private TextView textView;
    //MainActivity _mainAct;
    //public HttpResponsAsync(MainActivity mainAct) {
    //    _mainAct = mainAct;
    //}
    private CallBackTask callbacktask;
    private MainActivity m_Activity;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // doInBackground前処理
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection con = null;
        URL url = null;
        String urlSt = "http://zny.daddy-pool.work/api/stats";

        try {
            // URLの作成
            url = new URL(urlSt);
            // 接続用HttpURLConnectionオブジェクト作成
            con = (HttpURLConnection)url.openConnection();
            // リクエストメソッドの設定
            con.setRequestMethod("POST");
            // リダイレクトを自動で許可しない設定
            con.setInstanceFollowRedirects(false);
            // URL接続からデータを読み取る場合はtrue
            con.setDoInput(true);
            // URL接続にデータを書き込む場合はtrue
            con.setDoOutput(true);

            // 接続
            con.connect(); // ①
            InputStream in = con.getInputStream();
            String readSt = readInputStream(in);

            // 配列を取得する場合
            JSONArray jsonArray = new JSONObject(readSt).getJSONArray("オブジェクト名");
            //textView.setText("aaaaa");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String readInputStream(InputStream in) throws IOException, UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        String st = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        while((st = br.readLine()) != null)
        {
            sb.append(st);
        }
        try
        {
            in.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return sb.toString();
    }

    //@Override
    protected void onPostExecute(String result) {
        //super.onPostExecute(result);
               // doInBackground後処理

        // 読み出し元Activityに設置してあるTextViewを取得
        TextView textView = (TextView)this.m_Activity.findViewById(R.id.textView2);

        // TextViewの文字列をセット
        textView.setText(result);
        textView.setText("12345");
        return;
        //callbacktask.CallBack(result);
    }

    public void setOnCallBack(CallBackTask _cbj) {
        callbacktask = _cbj;
    }
    /**
     * コールバック用のstaticなclass
     */
    public static class CallBackTask {
        public void CallBack(String result) {
        }
    }
}
