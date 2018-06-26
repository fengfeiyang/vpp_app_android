package com.baotianqi.valpromise.http;


import com.baotianqi.valpromise.application.MyApplication;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2016/3/28.
 */
public class ParamUtil {
    private static Gson sGson;
    //    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Map<String, Object> getPatams () {
        Map<String, Object> params = new HashMap<>();
        try {
//            String time = format.format(System.currentTimeMillis());
            params.put("token", MyApplication.token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    public static RequestBody toRequestBody (Map map) {
        if (sGson == null) {
            synchronized (ParamUtil.class) {
                if (sGson == null) {
                    sGson = new Gson();
                }
            }
        }
        return RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), sGson.toJson(map));
    }
}
