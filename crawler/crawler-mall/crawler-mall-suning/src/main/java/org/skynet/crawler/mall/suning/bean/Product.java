package org.skynet.crawler.mall.suning.bean;

/**
 * 产品实体类
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/20
 */
public class Product {
    /**
     * 产品ID
     */
    private String pid;

    /**
     * 产品详情url
     */
    private String pUrl;

    /**
     * 图片url
     */
    private String picUrl;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 产品价格
     */
    private double price;

    /**
     * 产品价格获取url
     */
    private double priceUrl;

    /**
     *
     */
    private String cityCode;


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }


    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceUrl() {
        return priceUrl;
    }

    public void setPriceUrl(double priceUrl) {
        this.priceUrl = priceUrl;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
