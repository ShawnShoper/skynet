package org.skynet.crawler.common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

/**
 * Created by Shoper on 2017/3/19.
 * 爬取接口....
 */
public interface Crawler {
    /**
     * 列表抓取,传入列表页url
     *
     * @param url
     */
    Map<String, Object> crawlerList(String url, String cat1, String cat2, Map<String, String> other) throws IOException;

    /**
     * 单数据抓取
     *
     * @param url
     */
    Map<String, Object> crawler(String url, String cat1, String cat2, Map<String, String> other);
}
