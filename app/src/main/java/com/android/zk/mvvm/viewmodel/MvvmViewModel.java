package com.android.zk.mvvm.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.android.zk.mvc.mvp.mvvm.BR;
import com.android.zk.mvc.mvp.mvvm.databinding.ActivityMvvmBinding;
import com.android.zk.mvvm.model.MvvmModel;
import com.android.zk.util.http.IHttpCallBack;

/**
 * ViewModel
 *
 * @author zhukui
 */
public class MvvmViewModel extends BaseObservable {

    private ActivityMvvmBinding binding;
    private MvvmModel mvvmModel;
    private String result;

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    public MvvmViewModel(Context context, ActivityMvvmBinding binding) {
        this.binding = binding;
        mvvmModel = new MvvmModel();
        setResult("success");
    }

    public void getData(View view) {
        mvvmModel.getData(new IHttpCallBack<String>() {
            @Override
            public void onSuccess(String success) {
                setResult(success);
            }

            @Override
            public void onError(String error) {
                setResult(error);
            }
        });
    }
}
