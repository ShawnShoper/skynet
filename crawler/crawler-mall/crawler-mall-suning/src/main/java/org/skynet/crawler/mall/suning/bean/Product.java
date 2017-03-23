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
     * 产品分类1
     */
    private String cat1;

    /**
     * 产品分类2
     */
    private String cat2;

    /**
     * 产品详情url
     */
    private String detailUrl;

    /**
     * 图片url(多图片，以逗号分隔)
     */
    private String picUrls;
    /**
     * 产品名称
     */
    private String name;

    /**
     * 卖家
     */
    private String vendor;

    /**
     * 产品价格
     */
    private double price;

    /**
     * 产品价格获取url
     */
    private String priceUrl;

    /**
     * 城市编码
     */
    private String cityCode;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceUrl() {
        return priceUrl;
    }

    public void setPriceUrl(String priceUrl) {
        this.priceUrl = priceUrl;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
