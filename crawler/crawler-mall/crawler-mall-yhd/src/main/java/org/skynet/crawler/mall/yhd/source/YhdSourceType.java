package org.skynet.crawler.mall.yhd.source;

/**
 * Created by mac on 2017/3/20
 * User: cxp
 * PACKAGE_Name : org.skynet.crawler.mall.yhd.source
 * Project_Name : skynet
 * Date: 2017/3/20
 * Time: 21:39
 * 一号店数据类型
 */
public enum YhdSourceType implements SourceType {
    Index("首页"),

    ListY("列表页"),

    Detail("详情");

    private String des;

    private  YhdSourceType(String des){
        this.des = des;
    }

    @Override
    public String description() {
        return this.des;
    }
}
