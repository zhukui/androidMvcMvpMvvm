package com.android.zk.util.http;

/**
 * 接口回调
 *
 * @param <T>
 * @author zhukui
 */
public interface IHttpCallBack<T> {

    void onSuccess(T bean);

    void onError(String error);
}
