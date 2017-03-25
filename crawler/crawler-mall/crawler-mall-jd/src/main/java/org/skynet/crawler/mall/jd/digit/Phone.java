package org.skynet.crawler.mall.jd.digit;

import org.apache.commons.collections.map.HashedMap;
import org.jsoup.nodes.Element;
import org.skynet.crawler.mall.jd.Detail;

import java.util.Map;

/**
 * Created by Shoper on 2017/3/25.
 */
public class Phone implements Detail {
    public Map<String, Object> crawler(Element element) {
        System.out.println(element.toString());
        Map<String, Object> data = new HashedMap();
        return data;
    }

}
