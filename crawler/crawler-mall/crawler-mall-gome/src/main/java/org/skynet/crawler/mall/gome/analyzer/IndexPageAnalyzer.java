package org.skynet.crawler.mall.gome.analyzer;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.skynet.crawler.mall.gome.fetcher.PageContent;

/**
 * Created by Medusar on 19/03/2017.
 */
public class IndexPageAnalyzer extends JsoupAnalyzer implements Analyzer {


    @Override
    public AnalyzeResult analyze(PageContent pageContent) {
        Document document = super.parse(pageContent);

        Element lisnav = document.getElementById("lisnav");

        if (lisnav != null) {
            AnalyzeResult analyzeResult = new AnalyzeResult();
            Elements lis = lisnav.children();
            for (Element li : lis) {
                String modelid = li.attr("modelid");
                System.out.println(modelid + ":#########");
                Elements datacodes = li.select("a[data-code]");
                if (datacodes != null) {
                    for (Element datacodeEl : datacodes) {
                        String code = datacodeEl.attr("data-code");
                        String href = datacodeEl.attr("href");
                        String text = datacodeEl.text();
                        System.out.println("#########");
                        System.out.println(code);
                        System.out.println(href);
                        System.out.println(text);
                    }
                }
            }

            return analyzeResult;
        } else {
            return AnalyzeResult.ofFailed("首页没有id=listnav的节点");
        }


    }

}
