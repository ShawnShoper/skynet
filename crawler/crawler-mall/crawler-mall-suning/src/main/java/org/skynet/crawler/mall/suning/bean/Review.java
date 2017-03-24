package org.skynet.crawler.mall.suning.bean;

/**
 * 评论实体类
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/24
 */
public class Review {
    /**
     * Id
     */
    private long commodityReviewId;

    /**
     * 评论内容
     */
    private String content;


   /**
     * 评论时间
     */
    private String publishTime;

   /**
     * 评论星级
     */
    private int qualityStar;

    /**
     * 评论源类型（android iphone、电脑等）
     */
    private String sourceSystem;


    /**
     * 用户
     */
    private User userInfo;

    /**
     * 商户
     */
    private Shop shopInfo;

    public long getCommodityReviewId() {
        return commodityReviewId;
    }

    public void setCommodityReviewId(long commodityReviewId) {
        this.commodityReviewId = commodityReviewId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getQualityStar() {
        return qualityStar;
    }

    public void setQualityStar(int qualityStar) {
        this.qualityStar = qualityStar;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    public Shop getShopInfo() {
        return shopInfo;
    }

    public void setShopInfo(Shop shopInfo) {
        this.shopInfo = shopInfo;
    }
}
