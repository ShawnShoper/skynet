package org.skynet.crawler.mall.suning.digit;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.skynet.crawler.mall.suning.Detail;
import org.skynet.crawler.mall.suning.common.CommonConstant;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 基类详情获取
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/27
 */
public  class BasicDetail implements Detail{
    /**
     * 公共属性获取
     * @param element
     * @return
     */
    @Override
    public Map<String, Object> crawler(Element element,String priceUrl) {
        Map<String, Object> data = new HashMap<>();
//        System.out.println( element.toString());
        try {
           getPrice(priceUrl);
        }catch (IOException e){
            e.printStackTrace();
        }
        extendCrawler(element,data);
        return data;
    }

    /**
     * 属性扩展
     * @param element
     */
    public void extendCrawler(Element element, Map<String, Object> data){
        /**
         * TODO Do Nothing
         */
    };

    public String  getPrice(String priceUrl) throws IOException{
        String priceStr =  Jsoup.connect(priceUrl).userAgent(CommonConstant.USER_AGENT).ignoreContentType(true).execute().body();
        JSONObject jsonObject=JSONObject.parseObject(priceStr.substring(priceStr.indexOf("(") + 1, priceStr.length() - 2));
        if(jsonObject.getJSONObject("data")!=null){
            System.out.println(jsonObject.getJSONObject("data").toJSONString());
        }
        return null;
    }
}
