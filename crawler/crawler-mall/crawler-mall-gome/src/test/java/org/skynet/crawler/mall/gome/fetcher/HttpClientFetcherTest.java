package org.skynet.crawler.mall.gome.fetcher;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.skynet.crawler.mall.gome.source.InputSource;
import org.skynet.crawler.mall.gome.source.SourceType;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public void testFetchNotExist() {
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


    @Test
    public void testFetchSample() throws IOException {
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

        PageContent pageContent = new HttpClientFetcher().fetch(source);

        IOUtils.write(pageContent.getResponseBody(), new FileWriter("src/main/resources/samples/index."
                + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".html"));
    }

}
