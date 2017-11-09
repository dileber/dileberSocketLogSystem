package com.drcosu.mianbaopai.model;

import java.io.Serializable;

/**
 * Created by DELL on 2017/10/20.
 */
public class ApkResult extends Result{
    String url;

    public ApkResult(String url, Integer code, String message) {
        super(code, message);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
