package org.skynet.crawler.common;

import org.jsoup.nodes.Element;

import java.util.Map;

/**
 * Created by Shoper on 2017/3/25.
 * 电商分类详情爬取接口
 */
public interface Detail {
    Map<String, Object> crawler(Element document,String url,String cat1,String cat2);
}
