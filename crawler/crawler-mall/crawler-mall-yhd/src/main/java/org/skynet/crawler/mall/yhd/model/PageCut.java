package org.skynet.crawler.mall.yhd.model;

/**
 * Created by mac on 2017/3/22
 * User: cxp
 * PACKAGE_Name : org.skynet.crawler.mall.yhd.model
 * Project_Name : skynet
 * Date: 2017/3/22
 * Time: 21:41
 */
public class PageCut {
    /**
     * id
     */
    private String id;

    /**
     * url
     */
    private String url;

    /**
     * 图片url
     */
    private String photoUrl;

    /**
     * 商品名称
     */
    private String shopName;

    /**
     * 价格
     */
    private double shopPrice;

    /**
     * 评论连接
     */
    private String commentaryUrl;

    /**
     * 评论数
     */
    private  String commentary;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getCommentaryUrl() {
        return commentaryUrl;
    }

    public void setCommentaryUrl(String priceUrl) {
        this.commentaryUrl = priceUrl;
    }

    /**
     * 测试使用
     * @return
     */
    @Override
    public String toString() {
        return "PageCut{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopPrice=" + shopPrice +
                ", commentaryUrl='" + commentaryUrl + '\'' +
                ", commentary='" + commentary + '\'' +
                '}';
    }
}
