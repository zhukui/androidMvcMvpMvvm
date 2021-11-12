package com.android.zk.mvc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.zk.mvc.mvp.mvvm.R;
import com.android.zk.util.http.IHttpCallBack;

/**
 * Mvc模式
 * <p>
 * 我们可以把一个xml布局看作一个View，Activity看作一个Control，Model由相关的数据操作类来承担。
 *
 * @author zhukui
 */
public class MvcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        final Button button = findViewById(R.id.btn_get_data);
        final TextView textView = findViewById(R.id.tv_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MvcModel mvcModel = new MvcModel();
                mvcModel.getData(new IHttpCallBack<String>() {
                    @Override
                    public void onSuccess(String success) {
                        textView.setText(success);
                    }

                    @Override
                    public void onError(String error) {
                        textView.setText(error);
                    }
                });
            }
        });
        textView.setText("success");
    }
}
