package org.skynet.crawler.mall.suning;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.skynet.crawler.EBCrawler;
import org.skynet.crawler.common.Crawler;
import org.skynet.crawler.mall.suning.bean.Product;

import java.io.IOException;
import java.net.URL;
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
public class SNCrawler extends EBCrawler {
    final int timeout = (int) TimeUnit.SECONDS.toMillis(20);

    public SNCrawler(String crawlPath) {
        super(crawlPath);
    }

    @Override
    public void visit(Page page, Links links) {
        WebDriver driver = null;
        driver = PageUtils.getWebDriver(page);
        List<WebElement> elements = driver.findElements(By.cssSelector("div.list ul li"));
        for (WebElement element:elements){
            System.err.println("name = [" + element.findElement(By.className("pro-name")).getText() + "], price = [" +  element.findElement(By.className("pro-price")).getText()  + "]");
        }


    }
}
