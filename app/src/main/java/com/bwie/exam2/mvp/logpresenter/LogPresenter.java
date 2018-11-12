package com.bwie.exam2.mvp.logpresenter;

import com.bwie.exam2.mvp.logmodel.LogModel;
import com.bwie.exam2.mvp.logview.LogView;

public class LogPresenter {
    private String url="http://www.xieast.com/api/user/login.php";
    private LogView iv;
    private LogModel model;
    public void onAttach(LogView iview){
        iv=iview;
        model=new LogModel();
    }
    public void requestData(){
        String phone = iv.getPhone();
        String pwd = iv.getPwd();
        model.getNetData(url+"?username="+phone+"&password="+pwd);
        model.getInter(new LogModel.GetData() {
            @Override
            public void onSuccse(String str) {
                iv.onSuccess(str);
            }
            @Override
            public void onFail(Exception e) {
                iv.onFail(e);
            }
        });
    }
    public void onDetach(){
        if(iv!=null){
            iv=null;
        }
    }
}
