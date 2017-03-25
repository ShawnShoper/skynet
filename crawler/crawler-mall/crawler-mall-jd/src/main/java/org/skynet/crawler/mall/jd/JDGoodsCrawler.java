package org.skynet.crawler.mall.jd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.map.HashedMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.shoper.feign.support.SpringMvcFeign;
import org.skynet.crawler.common.Crawler;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shoper on 2017/3/19.
 */
public class JDGoodsCrawler implements Crawler {
    final int timeout = (int) TimeUnit.SECONDS.toMillis(20);
    public LinkedBlockingDeque<Map<String, Object>> datas = new LinkedBlockingDeque<>();

    public static void main(String[] args) throws IOException {
        new JDGoodsCrawler().crawlerList("https://list.jd.com/list.html?cat=9987,653,655", "digit", "phone", null);
//        System.out.println(System.currentTimeMillis());
    }

    @Override
    public Map<String, Object> crawlerList(String url, String cat1, String cat2, Map<String, String> other) throws IOException {
        Document listDoc = Jsoup.parse(new URL(url), timeout);
        Elements items = listDoc.getElementsByClass("gl-item");
        items.stream().map(e ->
                "http:" + e.getElementsByTag("a").attr("href")
        ).map(link -> {
            int ind = link.indexOf("?");
            if (ind != -1)
                link = link.substring(0, ind);
            return link;
        })
                .map(e -> this.crawler(e, cat1, cat2, other))
                .forEach(System.out::println);
        return null;
    }

    @Override
    public Map<String, Object> crawler(String url, String cat1, String cat2, Map<String, String> other) {
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
        //商品价格单独获取，避免价格接口导致商品信息效率过低
        //获取详情信息
        Element ptable = goodsDoc.getElementsByClass("Ptable").get(0);
        try {
            Class aClass =  Class.forName("org.skynet.crawler.mall.jd.digit.Phone");
            Detail o = (Detail) aClass.newInstance();
            o.crawler(ptable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
