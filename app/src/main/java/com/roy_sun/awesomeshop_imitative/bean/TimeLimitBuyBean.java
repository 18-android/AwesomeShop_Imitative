package com.roy_sun.awesomeshop_imitative.bean;

import java.util.List;

/**
 * @创建者：Fox
 * @创建时间：2016/2/19
 * @描述： ${TODO}
 * @修改者：$TODO
 * @修改时间：2016/2/19 21:18
 */
public class TimeLimitBuyBean {
    public int                   listCount;
    public List<ProduceListBean> productList;
    public String                response;

    public class ProduceListBean {
       public int id	        ;//2
       public long leftTime	;//17000
       public int limitPrice	;//1
       public String name	    ;//粉色毛衣
       public String pic	        ;///images/product/detail/q1.jpg
       public int price	    ;//100
    }
}
