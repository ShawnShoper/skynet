package org.skynet.crawler.mall.yhd;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.skynet.crawler.common.Crawler;
import org.skynet.crawler.mall.yhd.model.GetResouce;
import org.skynet.crawler.mall.yhd.model.PageCut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by mac on 2017/3/21
 * User: cxp
 * PACKAGE_Name : org.skynet.crawler.mall.yhd
 * Project_Name : skynet
 * Date: 2017/3/21
 * Time: 21:57
 */
public class YHDCrawler implements Crawler {
    public static final int timeout = (int) TimeUnit.SECONDS.toMillis(60);
    public static final String s = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) " +
            "Chrome/56.0.2924.87 Safari/537.36";

    /**
     *
     * @param url
     * @param cat1
     * @param cat2
     * @param other
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, Object> crawlerList(String url, String cat1, String cat2, Map<String, String> other) throws IOException {
        Document listDocument = Jsoup.connect(url).userAgent(s).get();
        Elements elements = listDocument.select("div.mod_search_pro");
        List<PageCut> pageCutList = new ArrayList<PageCut>();
        for(int i =0;i<elements.size();i++){
            String shopName = elements.get(i).select("p.proName.clearfix").text();
            String price = elements.get(i).select("em.num").attr("yhdprice");
            String shopUrl = elements.get(i).select("a.mainTitle").attr("href");
            String id = elements.get(i).select("a.mainTitle").attr("id");
            String photoUrl = elements.get(i).select("img").attr("src");
            PageCut pageCut = new PageCut();
            pageCut.setShopName(shopName);
            pageCut.setId(id);
            pageCut.setUrl(shopUrl);
            pageCut.setShopPrice(Double.valueOf(price));
            pageCutList.add(pageCut);
        }
        for(PageCut p : pageCutList){
            System.out.println(p.toString());
        }
        return null;
    }

    /**
     *
     * @param url
     * @param cat1
     * @param cat2
     * @param other
     * @return
     */
    @Override
    public Map<String, Object> crawler(String url, String cat1, String cat2, Map<String, String> other) {

        return null;
    }


    public Map<String,Object> getCommentary(List<PageCut> list) throws IOException {

        return null;
    }

    //"item good-comment
    @Test
    public void TestVoid() throws IOException {
        Document listDocument = Jsoup.connect("http://club.yhd.com/review/56552482.html?tp=15.66315695.1684.all_reviews.1.Lg9tpF^-10-CxRud&ti=3AR5I1").
                userAgent(s).post();
        Elements elements = listDocument.select("div.item.good-comment");
        System.out.println(elements.size());
        for (int i =0;i<elements.size();i++){
            String userName =  elements.get(i).select("span.name").text();
            String text = elements.get(i).select("span.text").text();
            System.out.println(text);
        }
        GetResouce getResouce = new GetResouce();


    }
}
