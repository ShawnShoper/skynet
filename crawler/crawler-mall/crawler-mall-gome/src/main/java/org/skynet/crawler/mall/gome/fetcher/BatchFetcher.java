package org.skynet.crawler.mall.gome.fetcher;

import org.skynet.crawler.mall.gome.source.InputSource;

import java.util.List;

/**
 * Created by Medusar on 19/03/2017.
 */
public interface BatchFetcher extends Fetcher {
    List<PageContent> fetchAll(List<InputSource> sourceList);
}
