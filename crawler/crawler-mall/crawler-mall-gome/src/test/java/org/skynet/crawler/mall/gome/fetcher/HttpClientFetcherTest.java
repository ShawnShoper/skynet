package org.skynet.crawler.mall.gome.fetcher;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.skynet.crawler.mall.gome.source.InputSource;
import org.skynet.crawler.mall.gome.source.SourceType;

/**
 * Created by Medusar on 19/03/2017.
 */
public class HttpClientFetcherTest {

    @Test
    public void testFetchNormal() {
        HttpClientFetcher fetcher = new HttpClientFetcher();

        InputSource source = new InputSource() {
            @Override
            public String url() {
                return "http://www.gome.com.cn";
            }

            @Override
            public SourceType type() {
                return null;
            }
        };

        PageContent pageContent = fetcher.fetch(source);

        System.out.println(JSON.toJSONString(pageContent));
    }

    @Test
    public void testFetchNotExist(){
        HttpClientFetcher fetcher = new HttpClientFetcher();

        InputSource source = new InputSource() {
            @Override
            public String url() {
                return "http://notexist.exsit";
            }

            @Override
            public SourceType type() {
                return null;
            }
        };

        PageContent pageContent = fetcher.fetch(source);

        System.out.println(JSON.toJSONString(pageContent));
    }

}
