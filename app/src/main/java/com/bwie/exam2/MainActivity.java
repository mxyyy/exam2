package com.bwie.exam2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import com.bwie.exam2.mvp.logpresenter.LogPresenter;
import com.bwie.exam2.mvp.logview.LogView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LogView {

    private CheckBox cb_jizu,cb_zidong;
    private Button btn_log;
    private EditText ed_phone,ed_pwd;
    private LogPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
    }

    private void initView() {
        ed_phone=findViewById(R.id.ed_phone);
        ed_pwd=findViewById(R.id.ed_pwd);
        btn_log=findViewById(R.id.btn_log);
        cb_jizu=findViewById(R.id.cb_jizu);
        cb_zidong=findViewById(R.id.cb_zidong);
        btn_log.setOnClickListener(this);
        presenter=new LogPresenter();
        presenter.onAttach(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_log:
                presenter.requestData();
                break;
    }
}
    @Override
    public String getPhone() {
        return ed_phone.getText().toString().trim();
    }

     @Override
    public String getPwd() {
        return ed_pwd.getText().toString().trim();
    }

    @Override
    public void onSuccess(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                if(str.equals("登录成功")){
                    Intent intent=new Intent(MainActivity.this, MyInforActivity.class);
                    intent.putExtra("name",ed_phone.getText().toString().trim());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onFail(final Exception e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.onDetach();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
