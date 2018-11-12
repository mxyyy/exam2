package com.bwie.exam2.mvp.logmodel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import com.bwie.exam2.utils.OkHttpUtils;


public class LogModel {
    public  interface GetData{
        void onSuccse(String str);
        void  onFail(Exception e);
    }
    private GetData getData;
    public void getInter(GetData data){
        getData=data;
    }
    public void getNetData(String str){
        OkHttpUtils.getInstence().get(str, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getData.onFail(e);
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                String string = response.body().string();
                JSONObject object = null;
                try {
                    object = new JSONObject(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    String str = object.getString("msg");
                    getData.onSuccse(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}




