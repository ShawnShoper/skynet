package org.skynet.crawler.mall.suning;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.skynet.crawler.common.Crawler;
import org.skynet.crawler.mall.suning.bean.Commodity;
import org.skynet.crawler.mall.suning.bean.Review;
import org.skynet.crawler.mall.suning.common.CommonConstant;

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
    @Override
    public Map<String, Object> crawlerList(String url, String cat1, String cat2, Map<String, String> other) throws IOException {
        Document listDoc = Jsoup.connect(url).userAgent(CommonConstant.USER_AGENT).get();
        Elements items = listDoc.select("div#filter-results ul li");
//        String cityCode=listDoc.getElementById("citybName").attr("role").split(",")[1];
        items.stream().map(e->
                "http:"+e.select("div.img-block a").attr("href")
        ).map(
                detailUrl->this.crawler(detailUrl,null,null,null)
        ).forEach(System.out::println);

//        List<Commodity> commodities =new ArrayList<>();
//        for (int i = 0; i < items.size(); i++) {
//            String proName=items.get(i).select("p.sell-point a").html().replaceAll("<.+.?>", "");;
//
//
//            String pId=items.get(i).select("em[datasku]").attr("datasku");
//            String detailUrl="http:"+items.get(i).select("div.img-block a").attr("href");
//            String pic="http:"+items.get(i).select("div.img-block a img").attr("src2");
//            String vendor=items.get(i).select("p.seller").attr("salesname");
//
//            Commodity commodity =new Commodity();
//            commodity.setCityCode(cityCode);
//            commodity.setPid(pId);
//            commodity.setDetailUrl(detailUrl);
//            commodity.setPicUrls(pic);
//            commodity.setName(proName);
//            commodity.setVendor(vendor);
//            commodity.setPriceUrl(getPriceUrl(commodity));
//            commodity.setPrice((Double) crawler(commodity.getPriceUrl(), null, null, null).get("price"));
//            commodities.add(commodity);
////            commodities.stream().forEach(pro -> System.out.println(JSONObject.toJSONString(pro)));
//            commodities.stream().forEach(System.out::println);
//        }
        return null;
    }

    @Override
    public Map<String, Object> crawler(String url, String cat1, String cat2, Map<String, String> other) {
        Map<String, Object> data = new HashMap<>();
        Document goodsDoc = null;
        try {
            String cityId="010";
            goodsDoc =  Jsoup.connect(url).userAgent(CommonConstant.USER_AGENT).ignoreContentType(true).get();
            data.put("title",goodsDoc.getElementById("itemDisplayName").html().replaceAll("<.+.?>", ""));
            data.put("url", url);
            data.put("uid","SN"+goodsDoc.getElementById("ga_itemDataBean_itemID").val());
            String curPartNumber=goodsDoc.getElementById("curPartNumber").val();
            Element proElement=goodsDoc.getElementsByClass("proinfo").get(0);
            Detail detail=(Detail)Class.forName("org.skynet.crawler.mall.suning.digit.BasicDetail").newInstance();
            detail.crawler(proElement,getPriceUrl(curPartNumber,cityId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public  void getReview( String pid){
        String[] x= pid.split("\\|");
        int page=1;
        String reviewUrl="http://review.suning.com/ajax/review_lists/general-000000000"+x[0]+"-"+x[x.length-1]+"-total-"+page+"-default-1-----reviewList.htm?callback=reviewList";
        String reviewsStr=null;
        try {
            reviewsStr =  Jsoup.connect(reviewUrl).userAgent(CommonConstant.USER_AGENT).ignoreContentType(true).execute().body();
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
    public  String getPriceUrl(String curPartNumber,String cityId){
//        return "http://pas.suning.com/nspcsale"+"_0"+"_"+curPartNumber+curPartNumber;
        return "http://pas.suning.com/nspcsale_0_"+curPartNumber+"_"+curPartNumber+"_"+"0000000000"+"__"+cityId+"_0100101_20089_Z001__.html";
//        String[] x= commodity.getPid().split("\\|");
//        return  "http://ds.suning.cn/ds/prices/"+"000000000"+x[0]+"-"+ commodity.getCityCode()+"-"+x[x.length-1]+"-2-SES.priceCenterShow.priceCenterCallBack.jsonp";
    }

}
