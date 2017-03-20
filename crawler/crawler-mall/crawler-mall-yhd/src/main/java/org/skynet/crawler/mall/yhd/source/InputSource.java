package org.skynet.crawler.mall.yhd.source;

/**
 * Created by mac on 2017/3/20
 * User: cxp
 * PACKAGE_Name : org.skynet.crawler.mall.yhd.source
 * Project_Name : skynet
 * Date: 2017/3/20
 * Time: 21:37
 *
 * 输入数据源
 */
public interface InputSource {
    /**
     * url
     * @return
     */
    String url();

    /**
     * 资源类型
     * @return
     */
    SourceType type();
}
