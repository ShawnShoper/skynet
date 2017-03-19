package org.skynet.crawler.mall.jd;

import org.apache.commons.collections.map.HashedMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.shoper.feign.support.SpringMvcFeign;
import org.skynet.crawler.common.Crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shoper on 2017/3/19.
 */
public class JDCrawler implements Crawler {
    final int timeout = (int) TimeUnit.SECONDS.toMillis(20);
    public LinkedBlockingDeque<Map<String, Object>> datas = new LinkedBlockingDeque<>();

    public static void main(String[] args) throws IOException {
        new JDCrawler().crawlerList("https://list.jd.com/list.html?cat=9987,653,655");
    }

    @Override
    public Map<String, Object> crawlerList(String url, Object... obj) throws IOException {
        Document listDoc = Jsoup.parse(new URL(url), timeout);
        Elements items = listDoc.getElementsByClass("gl-item");
        items.stream().parallel().map(e ->
                "http:" + e.getElementsByTag("a").attr("href")
        ).map(link -> {
            int ind = link.indexOf("?");
            if (ind != -1)
                link = link.substring(0, ind);
            return link;
        })
                .map(this::crawler)
                .forEach(System.out::println);
        return null;
    }

    @Override
    public Map<String, Object> crawler(String url, Object... obj) {
        //价格接口
        //https://p.3.cn/prices/mgets?type=1&area=2_2815_51975_0&skuIds=J_2967929
        Map<String, Object> data = new HashedMap();
        String skuid = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
        data.put("url", url);
        data.put("skuid", skuid);
        Document goodsDoc = null;
        try {
            goodsDoc = Jsoup.parse(new URL(url), timeout);
        } catch (IOException e) {
        }
        if (Objects.isNull(goodsDoc)) return data;
        String title = goodsDoc.getElementsByClass("sku-name").get(0).text();
        data.put("name", title);
        try {
            crawlerPrice(skuid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private double crawlerPrice(String skuid) throws IOException {
//        String text = Jsoup.parse(new URL("https://p.3.cn/prices/mgets?type=1&area=2_2815_51975_0&skuIds=J_" + skuid), timeout).text();
        Price target = SpringMvcFeign.target(Price.class, "https://p.3.cn/prices/mgets");
        String price = target.getPrice("J_" + skuid, "2_2815_51975_0", "1");
        System.out.println(price);
        return 0.0d;
    }
}
