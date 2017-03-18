package org.skynet.crawler.mall.gome.sink;

import org.skynet.crawler.mall.gome.analyzer.AnalyzeResult;

/**
 * Created by Medusar on 19/03/2017.
 */
public interface Sink {

    SinkResult sink(AnalyzeResult analyzeResult);

}
