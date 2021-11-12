package com.android.zk.mvp.presenter;

import com.android.zk.mvp.contract.MvpContract;
import com.android.zk.util.http.IHttpCallBack;
import com.android.zk.mvp.model.MvpModel;

import java.lang.ref.WeakReference;

/**
 * PresenterImpl - 实现业务逻辑并刷新页面
 *
 * @author zhukui
 */
public class MvpPresenterImpl<V extends MvpContract.View> implements MvpContract.Presenter {

    /**
     * Presenter持有弱引用View，并在页面detach时清空持有的弱引用View
     */
    protected WeakReference<V> mView;
    protected MvpModel mMvpModel;

    public MvpPresenterImpl(V view) {
        mView = new WeakReference<V>(view);
        view.setPresenter(this);
        mMvpModel = new MvpModel();
    }

    protected boolean isViewActive() {
        return mView != null && mView.get().isActive();
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
    }

    @Override
    public void getData() {
        if (!isViewActive()) {
            return;
        }
        mMvpModel.getData(new IHttpCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                mView.get().refreshUI("success");
            }

            @Override
            public void onError(String error) {
                mView.get().refreshUI("error");
            }
        });
    }

    @Override
    public void start() {
        if (!isViewActive()) {
            return;
        }
        mView.get().showLoading();
    }
}
