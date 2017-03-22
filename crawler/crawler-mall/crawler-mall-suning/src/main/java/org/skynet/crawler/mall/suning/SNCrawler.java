package org.skynet.crawler.mall.suning;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.skynet.crawler.common.Crawler;
import org.skynet.crawler.mall.suning.bean.Product;

import java.io.IOException;
import java.net.URL;
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
        List<Product> products=new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            String proName=items.get(i).select("p.sell-point a").html().replaceAll("<.+.?>","");;
            String pId=items.get(i).select("em[datasku]").attr("datasku");
//            if(items.get(i).getElementsByClass("no-goods").size()>0) continue;
            Product product=new Product();
            product.setPid(pId);
            product.setCityCode(cityCode);
            product.setName(proName);
            products.add(product);
            System.err.print("proName : " + proName);
            crawler(getPriceUrl(product),null,null,null);
        }
        return null;
    }

    @Override
    public Map<String, Object> crawler(String url, String cat1, String cat2, Map<String, String> other) {
        Map<String, Object> data = new HashedMap();
        Document goodsDoc = null;
        try {
            goodsDoc =  Jsoup.connect(url).userAgent(userAgent).ignoreContentType(true).get();
            JSONObject jsonObject = JSONObject.parseObject(goodsDoc.body().html().substring(goodsDoc.body().html().indexOf("(") + 1, goodsDoc.body().html().length() - 2).replaceAll("&quot;", "\"")).getJSONArray("rs").getJSONObject(0);
            data.put("price", jsonObject.getString("price") == null || jsonObject.getString("price").equals("") ? -1 : jsonObject.getDoubleValue("price"));
            System.err.println("  price : " + data.get("price"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public  String getPriceUrl( Product product){
        String[] x=product.getPid().split("\\|");
        return  "http://ds.suning.cn/ds/prices/"+"000000000"+x[0]+"-"+product.getCityCode()+"-"+x[x.length-1]+"-2-SES.priceCenterShow.priceCenterCallBack.jsonp";
    }
}
