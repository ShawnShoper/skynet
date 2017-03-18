package org.skynet.crawler.mall.gome.analyzer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.skynet.crawler.mall.gome.fetcher.PageContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Medusar on 19/03/2017.
 */
public abstract class JsoupAnalyzer implements Analyzer {

    public Document parse(PageContent pageContent) {
        return Jsoup.parse(pageContent.getResponseBody());
    }

    @Override
    public List<AnalyzeResult> analyze(List<PageContent> pageContents) {
        List<AnalyzeResult> result = new ArrayList<>();
        for (PageContent pageContent : pageContents) {
            try {
                result.add(this.analyze(pageContent));
            } catch (Exception e) {
                e.printStackTrace();
                //TODO: log
            }
        }
        return result;
    }
}
