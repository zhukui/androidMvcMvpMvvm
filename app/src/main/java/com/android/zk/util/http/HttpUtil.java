package com.android.zk.util.http;

import android.os.Handler;
import android.os.Looper;

import java.util.Random;
import java.util.concurrent.Executors;

/**
 * 模拟Http接口请求
 *
 * @author zhukui
 */
public class HttpUtil {

    /**
     * Handler
     */
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    /**
     * 请求数据
     *
     * @param callBack
     */
    public static void requestData(final IHttpCallBack callBack) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        boolean result = new Random().nextBoolean();
                        if (result) {
                            callBack.onSuccess("success");
                        } else {
                            callBack.onError("error");
                        }
                    }
                });
            }
        });
    }

}
