package org.skynet.crawler.mall.yhd.model;

/**
 * Created by mac on 2017/3/20
 * User: cxp
 * PACKAGE_Name : org.skynet.crawler.mall.yhd.fetcher
 * Project_Name : skynet
 * Date: 2017/3/20
 * Time: 21:47
 * 页面实体类
 */
public class PageContentModel {

    /**
     * url
     */
    private String url;

    /**
     * 状态码
     */
    private int httpStatusCode;

    /**
     * 返回结果
     */
    private String responseBody;


    /**
     * 状态行
     */
    private String httpStatusLine;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getHttpStatusLine() {
        return httpStatusLine;
    }

    public void setHttpStatusLine(String httpStatusLine) {
        this.httpStatusLine = httpStatusLine;
    }
}
