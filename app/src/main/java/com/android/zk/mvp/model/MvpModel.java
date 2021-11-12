package com.android.zk.mvp.model;

import com.android.zk.util.http.HttpUtil;
import com.android.zk.util.http.IHttpCallBack;

/**
 * 模拟请求接口数据
 *
 * @author zhukui
 */
public class MvpModel {

    /**
     * 模拟获取数据
     */
    public void getData(final IHttpCallBack callBack) {
        HttpUtil.requestData(callBack);
    }
}
