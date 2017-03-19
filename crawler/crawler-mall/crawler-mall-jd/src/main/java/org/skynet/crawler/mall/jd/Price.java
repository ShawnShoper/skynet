package org.skynet.crawler.mall.jd;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ShawnShoper on 2017/3/19.
 */

public interface Price {
    @RequestMapping(value = "/prices/mgets",method = RequestMethod.GET)
    @ResponseBody               //skuids
    String getPrice(@RequestParam("skuids") String skuids,@RequestParam("area") String area,@RequestParam("type") String type);
}
