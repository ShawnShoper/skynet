package org.skynet.crawler.mall.gome.analyzer;

import org.skynet.crawler.mall.gome.fetcher.PageContent;

import java.util.List;

/**
 * Created by Medusar on 19/03/2017.
 */
public interface Analyzer {

    AnalyzeResult analyze(PageContent pageContent);

    List<AnalyzeResult> analyze(List<PageContent> pageContents);

}
