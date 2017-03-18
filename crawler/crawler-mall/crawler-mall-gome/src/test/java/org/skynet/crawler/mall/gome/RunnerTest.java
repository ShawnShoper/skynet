package org.skynet.crawler.mall.gome;

import org.junit.Test;
import org.skynet.crawler.mall.gome.analyzer.IndexPageAnalyzer;
import org.skynet.crawler.mall.gome.fetcher.HttpClientFetcher;
import org.skynet.crawler.mall.gome.fetcher.PageContent;
import org.skynet.crawler.mall.gome.source.InputSource;
import org.skynet.crawler.mall.gome.source.SourceType;

/**
 * Created by Medusar on 19/03/2017.
 */
public class RunnerTest {

    @Test
    public void testRunner() {
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

        new IndexPageAnalyzer().analyze(pageContent);
    }

}
