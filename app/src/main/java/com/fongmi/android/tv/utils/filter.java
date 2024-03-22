package com.fongmi.android.tv.utils;

import android.os.Handler;
import android.os.Looper;

import com.github.catvod.net.OkHttp;
import com.google.gson.Gson;

import java.util.List;

public class filter {

    public static class FilterCache {
        private static List<String> filterList;

        public static List<String> getFilterList() {
            if (filterList == null) {
                try {
                    String url = "https://atomgit.com/lintech/tms/raw/master/fiter.json";
                    String resStr = OkHttp.string(url);
                    if (resStr.isEmpty()) {
                        resStr = "{'data':['公众号','神秘的哥哥们','：',':','|','｜','防失联','关注','【','】']}";
                        System.out.println("获取在线数据: 失败");
                        System.out.println("加载默认数据: " + resStr);
                    }
                    else{
                        System.out.println("获取在线数据: 成功");
                    }
                    Gson gson = new Gson();
                    Res res = gson.fromJson(resStr, Res.class);
                    filterList = res.data;
                } catch (Exception e) {
                    // 处理其他异常
                    e.printStackTrace();
                }
            }
            return filterList;
        }



        public static void clearCache() {
            filterList = null;
        }
    }

    public static class Res {
        private List<String> data;

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }
    }

    public static String filterString(String input) {
        try {
            List<String> filterList = FilterCache.getFilterList();
            for (String filter : filterList) {
                input = input.replace(filter, "");
            }
            return input;
        } catch (Exception e) {
            e.printStackTrace();
            return input;
        }
    }
}
