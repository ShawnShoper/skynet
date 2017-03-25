package org.skynet.crawler.mall.jd;

import org.jsoup.nodes.Element;

import java.util.Map;

/**
 * Created by Shoper on 2017/3/25.
 */
public interface Detail {
    Map<String, Object> crawler(Element document);
}
