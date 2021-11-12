package com.android.zk.mvp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.android.zk.mvc.mvp.mvvm.R;

/**
 * Mvp - 主流开发框架
 * <p>
 * 说明：
 * 1.this code is based on Google MVP
 * 2.实现了Presenter持有弱引用View，并在页面detach时清空持有的弱引用View
 *
 * @author zhukui
 */
public class MvpActivity extends AppCompatActivity {

    public static final String FRAGMENT_TAG = "fragment_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        init();
    }

    private void init() {
        //初始化view
        FragmentManager fragmentManager = getSupportFragmentManager();
        MvpFragment fragment = (MvpFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (fragment == null) {
            fragment = MvpFragment.newInstance("param1");
            fragmentManager.beginTransaction().add(R.id.fl_container, fragment, FRAGMENT_TAG).commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
