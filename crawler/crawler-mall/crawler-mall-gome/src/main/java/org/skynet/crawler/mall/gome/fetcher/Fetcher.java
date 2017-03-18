package org.skynet.crawler.mall.gome.fetcher;

import org.skynet.crawler.mall.gome.source.InputSource;

/**
 * Created by Medusar on 19/03/2017.
 */
public interface Fetcher {

    PageContent fetch(InputSource source);

}
