package com.roy_sun.awesomeshop_imitative.bean;

import java.io.Serializable;

/**
 * 获取数据的基类 其他bean应当继承此类进行扩展
 */

public class BaseBean implements Serializable {


    protected   long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
