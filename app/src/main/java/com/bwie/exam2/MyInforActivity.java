package com.bwie.exam2;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import com.bwie.exam2.fragment.MyInfor;
import com.bwie.exam2.fragment.MyList;

public class MyInforActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private String []strs={"我的数据","我的名片"};
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_infor);
        
        initView();
        setvpAdapter();
    }

    private void setvpAdapter() {
        fragmentList=new ArrayList<>();
        fragmentList.add(new MyList());
        fragmentList.add(new MyInfor());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return strs[position];
            }
        });
    }

    private void initView() {
        tab=findViewById(R.id.tab);
        vp=findViewById(R.id.vp);
        tab.setupWithViewPager(vp);
    }
}
