package com.bwie.exam2.mvp.logview;


public interface LogView  {
    String getPhone();
    String getPwd();
    void onSuccess(String str);
    void  onFail(Exception e);
}
