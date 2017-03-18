package org.skynet.crawler.mall.gome.source;

/**
 * Created by Medusar on 19/03/2017.
 */
public enum GomeSourceType implements SourceType {

    Index("首页"),

    List("列表页"),

    Detail("详情页"),;

    private String description;

    GomeSourceType(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return this.description;
    }
}
