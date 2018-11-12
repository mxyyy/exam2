package com.bwie.exam2.utils;


;import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtils {
    public static  OkHttpUtils instence;
    public static OkHttpClient client;
    private OkHttpUtils(){
        if(null==client){
            synchronized (OkHttpClient.class){
                client=new OkHttpClient();
            }
        }
    }
    public static OkHttpUtils getInstence(){
        if (null==instence){
            synchronized (OkHttpUtils.class){
                instence=new OkHttpUtils();
            }
        }
     return instence;
    }
    //封装get请求
    public void get(String url, Callback callback){
        Request request=new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    //封装post请求(以FormBody方式)
    public void  post(String url, FormBody formBody, Callback callback){
        Request request=new Request.Builder().url(url).method("POST", formBody).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    //封装post请求(以....方式)

}
