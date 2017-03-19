package org.skynet.crawler.mall.jd;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ShawnShoper on 2017/3/19.
 */
public interface Price {
    @ResponseBody
    String getPrice(String skuid, String area, String type);
}
