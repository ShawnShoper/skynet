package org.skynet.crawler.mall.suning.bean;

/**
 * 用户实体
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/24
 */
public class User {
    /**
     * 用户名
     */
    private String nickName;

    private String levelId;

    private String levelName;

    /**
     * 用户头像url
     */
    private String imgUrl;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
