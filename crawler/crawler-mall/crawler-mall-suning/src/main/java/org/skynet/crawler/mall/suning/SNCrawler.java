package org.skynet.crawler.mall.suning;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.skynet.crawler.common.Crawler;
import org.skynet.crawler.mall.suning.bean.Commodity;
import org.skynet.crawler.mall.suning.bean.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 苏宁易购爬虫器
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/20
 */
public class SNCrawler implements Crawler {
    final int timeout = (int) TimeUnit.SECONDS.toMillis(20);
    final String userAgent="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31";
    @Override
    public Map<String, Object> crawlerList(String url, String cat1, String cat2, Map<String, String> other) throws IOException {
        Document listDoc = Jsoup.connect(url).userAgent(userAgent).get();
        Elements items = listDoc.select("div#filter-results ul li");
//        String cityCode=listDoc.getElementById("citybName").attr("role").split(",")[1];
        String cityCode="9017";
        List<Commodity> commodities =new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            String proName=items.get(i).select("p.sell-point a").html().replaceAll("<.+.?>", "");;
            String pId=items.get(i).select("em[datasku]").attr("datasku");
            String detailUrl="http:"+items.get(i).select("div.img-block a").attr("href");
            String pic="http:"+items.get(i).select("div.img-block a img").attr("src2");
            String vendor=items.get(i).select("p.seller").attr("salesname");

            Commodity commodity =new Commodity();
            commodity.setCityCode(cityCode);
            commodity.setPid(pId);
            commodity.setDetailUrl(detailUrl);
            commodity.setPicUrls(pic);
            commodity.setName(proName);
            commodity.setVendor(vendor);
            commodity.setPriceUrl(getPriceUrl(commodity));
            commodity.setPrice((Double) crawler(commodity.getPriceUrl(), null, null, null).get("price"));
            commodities.add(commodity);
           commodities.stream().forEach(pro -> System.out.println(JSONObject.toJSONString(pro)));
        }
        return null;
    }

    @Override
    public Map<String, Object> crawler(String url, String cat1, String cat2, Map<String, String> other) {
        Map<String, Object> data = new HashMap<>();
        Document goodsDoc = null;
        try {
            goodsDoc =  Jsoup.connect(url).userAgent(userAgent).ignoreContentType(true).get();
            JSONObject jsonObject = JSONObject.parseObject(goodsDoc.body().html().substring(goodsDoc.body().html().indexOf("(") + 1, goodsDoc.body().html().length() - 2).replaceAll("&quot;", "\"")).getJSONArray("rs").getJSONObject(0);
            double price=jsonObject.getString("price") == null || jsonObject.getString("price").equals("") ? -1 : jsonObject.getDoubleValue("price");
            data.put("price", price);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public  String getPriceUrl( Commodity commodity){
        String[] x= commodity.getPid().split("\\|");
        return  "http://ds.suning.cn/ds/prices/"+"000000000"+x[0]+"-"+ commodity.getCityCode()+"-"+x[x.length-1]+"-2-SES.priceCenterShow.priceCenterCallBack.jsonp";
    }

    public  void getReview( String pid){
        String[] x= pid.split("\\|");
        int page=1;
        String reviewUrl="http://review.suning.com/ajax/review_lists/general-000000000"+x[0]+"-"+x[x.length-1]+"-total-"+page+"-default-1-----reviewList.htm?callback=reviewList";
        String reviewsStr=null;
        try {
            reviewsStr =  Jsoup.connect(reviewUrl).userAgent(userAgent).ignoreContentType(true).execute().body();
            JSONObject jsonObject=JSONObject.parseObject(reviewsStr.substring(reviewsStr.indexOf("(") + 1, reviewsStr.length() - 1));
            if(jsonObject.getString("commodityReviews")!=null){
                List<Review> reviewsList= JSON.parseArray(jsonObject.getString("commodityReviews"), Review.class);
                reviewsList.stream().forEach(review -> {
                    System.out.println(JSONObject.toJSONString(review));
                });
            }else{
                System.out.println("commodityCode = [" + pid + "] " + jsonObject.getString("returnMsg"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
