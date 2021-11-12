package com.android.zk.mvp.contract;

import com.android.zk.mvp.presenter.BasePresenter;
import com.android.zk.mvp.view.BaseView;

/**
 * Contract 契约类
 * <p>
 * Google MVP契约类，用于定义同一个界面的view和presenter的接口，
 * 通过规范的方法命名或注释，可以清晰的看到整个页面的逻辑。
 *
 * @author zhukui
 */
public interface MvpContract {

    interface Presenter extends BasePresenter {
        /**
         * 获取数据
         */
        void getData();

        /**
         * 拆卸View
         */
        void detachView();
    }

    interface View extends BaseView<Presenter> {
        /**
         * 显示加载中
         */
        void showLoading();

        /**
         * 刷新界面
         */
        void refreshUI(String result);

        /**
         * 显示错误界面
         */
        void showError();
    }
}
