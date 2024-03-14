package com.github.catvod.utils;

import android.net.Uri;

import com.github.catvod.net.OkHttp;

import java.io.File;

public class Github {

    public static final String URL = "https://ghcy.eu.org/https://raw.githubusercontent.com/bestpvp/tm/main";

    private static String getUrl(String path, String name) {
        String url = URL + "/" + path + "/" + name;
        return url;
    }

    public static String getJson(String name) {
        return getUrl("update/kitkat", name + ".json");
    }

    public static String getApk(String name) {
        return getUrl("update/kitkat", name);
    }

    public static String getSo(String url) {
        try {
            File file = new File(Path.so(), Uri.parse(url).getLastPathSegment());
            if (file.length() < 300) Path.write(file, OkHttp.newCall(url).execute().body().bytes());
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
