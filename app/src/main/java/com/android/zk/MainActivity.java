package com.android.zk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.android.zk.mvc.MvcActivity;
import com.android.zk.mvc.mvp.mvvm.R;
import com.android.zk.mvp.MvpActivity;
import com.android.zk.mvvm.MvvmActivity;

/**
 * 首页
 *
 * @author zhukui
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_mvc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MvcActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_mvp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MvpActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_mvvm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MvvmActivity.class);
                startActivity(intent);
            }
        });
    }
}
