package org.skynet.crawler.mall.suning;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/20
 */
public class PageUtils {
    private final static String  phantomjsKey="phantomjs.binary.path";
    private final static String  phantomjsCommand="D:/Program Files/phantomjs-2.0.0-windows/bin/phantomjs.exe";
    private final static String  parserjsPath="D:/MyEclipseWorkSpace/WebCollectorDemo/src/main/resources/parser.js ";

    /**
     * 获取webcollector 自带 htmlUnitDriver实例(模拟默认浏览器)
     *
     * @param page
     * @return
     */
    public static HtmlUnitDriver getDriver(Page page) {
        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);
        driver.get(page.getUrl());
        return driver;
    }

    /**
     * 获取webcollector 自带htmlUnitDriver实例
     *
     * @param page
     * @param browserVersion 模拟浏览器
     * @return
     */
    public static HtmlUnitDriver getDriver(Page page,
                                           BrowserVersion browserVersion) {
        HtmlUnitDriver driver = new HtmlUnitDriver(browserVersion);
        driver.setJavascriptEnabled(true);
        driver.get(page.getUrl());
        return driver;
    }

    /**
     * 获取PhantomJsDriver(可以爬取js动态生成的html)
     *
     * @param page
     * @return
     */
    public static WebDriver getWebDriver(Page page) {
        System.setProperty(phantomjsKey,phantomjsCommand);
        WebDriver driver = new PhantomJSDriver();
        driver.get(page.getUrl());
        return driver;
    }

    /**
     * 直接调用原生phantomJS(即不通过selenium)
     *
     * @param page
     * @return
     */
    public static String getPhantomJSDriver(Page page) throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process process = null;
        InputStream in=null;
        try {
            process = rt.exec(phantomjsCommand+
                    parserjsPath +
                    page.getUrl().trim());
            in = process.getInputStream();
            InputStreamReader reader = new InputStreamReader(
                    in, "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            StringBuffer sbf = new StringBuffer();
            String tmp = "";
            while((tmp = br.readLine())!=null){
                sbf.append(tmp);
            }
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null) in.close();
            if(process!=null) process.destroy();
        }
        return null;
    }
}
