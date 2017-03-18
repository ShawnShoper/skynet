package org.skynet.crawler.mall.gome.fetcher;

import org.shoper.http.httpClient.HttpClient;
import org.skynet.crawler.mall.gome.source.InputSource;

import java.util.concurrent.TimeUnit;

/**
 * Created by Medusar on 19/03/2017.
 */
public class HttpClientFetcher implements Fetcher {


    @Override
    public PageContent fetch(InputSource source) {
        String url = source.url();
        HttpClient httpClient = HttpClient.HttpClientBuilder.getInstances(url, "UTF-8", 10, TimeUnit.SECONDS, 0);

        String content = httpClient.doGet();

        PageContent pageContent = new PageContent();
        pageContent.setResponseBody(content);
        return pageContent;
    }

}
