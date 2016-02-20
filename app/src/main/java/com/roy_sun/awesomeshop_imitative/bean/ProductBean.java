package com.roy_sun.awesomeshop_imitative.bean;

import java.util.List;

/**
 * @创建者：Fox
 * @创建时间：2016/2/19
 * @描述： 商品详情界面的 BEAN对象
 * @修改者：$TODO
 * @修改时间：2016/2/19 22:20
 */
public class ProductBean {
    public Object product	    ;//Object
    public String response	;//product

    public class ProductInfoBean{
        public boolean available	    ;//true
        public List<ProductBigPicBean>    bigPic;//Array
        public int buyLimit	    ;//10
        public int commentCount	;//10
        public int id;	//2
        public String inventoryArea	;//全国
        public long leftTime	    ;//17000
        public float limitPrice	    ;//1
        public float marketPrice	    ;//180
        public String name	        ;//粉色毛衣
        public List<ProductBigPicBean> pics	;//Array
        public float price	        ;//100
        public List<ProductPropertyBean> productProperty;//Array
        public int score	        ;//2
    }
    public class ProductBigPicBean{
        public String pic	;// /images/product/detail/bigcar5.jpg
        public String pic1	;// /images/product/detail/bigcar6.jpg
        public String pic2	;// /images/product/detail/bigcar7.jpg
        public String pic3	;// /images/product/detail/bigcar8.jpg
    }
    public class ProductPropertyBean{
        public int id	;//1
        public String k	;//颜色
        public String v	;//红色
    }
}
