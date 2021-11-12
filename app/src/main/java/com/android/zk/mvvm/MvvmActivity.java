package com.android.zk.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.android.zk.mvc.mvp.mvvm.R;
import com.android.zk.mvc.mvp.mvvm.databinding.ActivityMvvmBinding;
import com.android.zk.mvvm.viewmodel.MvvmViewModel;

/**
 * Mvvm模式
 * <p>
 * 说明：简单使用，后续会完善使用
 *
 * @author zhukui
 */
public class MvvmActivity extends AppCompatActivity {

    private ActivityMvvmBinding binding;
    private MvvmViewModel mvvmViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //替换setContentView
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        mvvmViewModel = new MvvmViewModel(getApplication(), binding);
        //初始化viewModel
        binding.setViewModel(mvvmViewModel);
    }

}
