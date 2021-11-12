package com.android.zk.mvp.view;

import com.android.zk.mvp.presenter.BasePresenter;

/**
 * BaseView
 *
 * @author zhukui
 */
public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);

    boolean isActive();
}
