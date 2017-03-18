package org.skynet.crawler.mall.gome.fetcher;

import java.util.List;

/**
 * Created by Medusar on 19/03/2017.
 */
public class PageContent {
    private String url;

    private int httpStatusCode;
    private String httpStatusLine;

    private List<Header> headers;
    private String responseBody;


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

    public String getHttpStatusLine() {
        return httpStatusLine;
    }

    public void setHttpStatusLine(String httpStatusLine) {
        this.httpStatusLine = httpStatusLine;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }
}
