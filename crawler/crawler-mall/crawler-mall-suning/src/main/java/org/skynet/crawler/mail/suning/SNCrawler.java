package org.skynet.crawler.mail.suning;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.skynet.crawler.common.Crawler;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/20
 */
public class SNCrawler implements Crawler {
    final int timeout = (int) TimeUnit.SECONDS.toMillis(20);
    @Override
    public Map<String, Object> crawlerList(String url, Object... obj) throws IOException {
        Document listDoc = Jsoup.parse(new URL(url), timeout);
        Elements items = listDoc.getElementsByClass("gl-item");
        return null;
    }

    @Override
    public Map<String, Object> crawler(String url, Object... obj) {
        return null;
    }
}
