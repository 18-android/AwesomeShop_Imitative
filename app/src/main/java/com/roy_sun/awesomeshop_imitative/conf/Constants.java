package com.roy_sun.awesomeshop_imitative.conf;


import com.roy_sun.awesomeshop_imitative.utils.LogUtils;

public class Constants {
    public static final int  DEBUGLEVEL = LogUtils.LEVEL_ALL;
    public static final long TIMEOUT    = 5 * 60 * 1000;//5分钟

    public static final class PAY {
        public static final String PAYTYPE_ZHIFUBAO = "1";
        public static final String PAYTYPE_UUPAY    = "2";
        public static final String PAYTYPE_WEIXIN   = "3";
    }
    public static final class URL{
         public static final String BASE_HOME_URL = "http://188.188.1.6:8080/market";
    }
}
