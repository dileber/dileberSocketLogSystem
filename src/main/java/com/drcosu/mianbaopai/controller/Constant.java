package com.drcosu.mianbaopai.controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by shidawei on 16/7/18.
 */
public class Constant {

    public static final String SESSION_USER = "session_user";
    public static final String CONTEXT = "context";
    public static final String TITLE = "title";
    public static final String REDIS_ACCOUNT_TOKENS = "redis_account_tokens_";
    public static final String REDIS_REGIST_TOKENS = "redis_account_tokens_";
    public static final String REDIS_FORGET__TOKENS = "redis_forget_tokens_";
    public static final String REDIS_HOST_TAG = "redis_hot_tag_";
    public static final String REDIS_HOST_VIEWPOINT = "redis_hot_viewpoint_";
    public static final String REDIS_VIEWPOINT_IDS = "redis_viewpoint_ids_";

    public static final String APPNAME = "app_name";
    public static final String ISUSER = "isuser";

    public static ConcurrentMap<Integer,Integer> hostViewpointIds = new ConcurrentHashMap<Integer, Integer>();

    public static double huilv = 0.0643;

}
