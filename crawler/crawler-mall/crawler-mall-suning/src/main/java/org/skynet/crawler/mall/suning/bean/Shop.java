package org.skynet.crawler.mall.suning.bean;

/**
 * 商店实体
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/24
 */
public class Shop {
    /**
     * 商店Id
     */
    private String shopId;

    /**
     * 商店名称
     */
    private String shopName;

    /**
     * 商店类型
     */
    private String shopType;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }
}
