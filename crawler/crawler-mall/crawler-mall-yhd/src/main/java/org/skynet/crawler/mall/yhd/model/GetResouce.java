package org.skynet.crawler.mall.yhd.model;

/**
 * Created by mac on 2017/3/22
 * User: cxp
 * PACKAGE_Name : org.skynet.crawler.mall.yhd.documents
 * Project_Name : skynet
 * Date: 2017/3/22
 * Time: 21:07
 * 获取评论实体类
 *
 */
public class GetResouce {

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 商品名称
     *
     */
    private String photName;


    /**
     * 评论内容
     */
    private String commentary;

    /**
     * 评论人数
     */
    private String num;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhotName() {
        return photName;
    }

    public void setPhotName(String photName) {
        this.photName = photName;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
