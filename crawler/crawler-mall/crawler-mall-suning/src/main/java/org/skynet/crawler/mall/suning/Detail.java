package org.skynet.crawler.mall.suning;

import org.jsoup.nodes.Element;

import java.util.Map;

/**
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/27
 */
public interface Detail {
    Map<String, Object> crawler(Element document,String priceUrl);
}
