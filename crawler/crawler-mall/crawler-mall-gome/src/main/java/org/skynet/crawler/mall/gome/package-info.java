/**
 * Created by Medusar on 19/03/2017.
 * <p>
 * GOME数据抓取
 * <p>
 * 流程：
 * <p>
 * source --> fetcher --> analyzer --> sink
 * <p>
 * source为数据源，即需要抓取的数据
 * <p>
 * fetcher为数据抓取器，负责把source指定的数据抓取到本地
 * <p>
 * analyzer为抓取结果分析，比如页面解析及有效数据提取
 * <p>
 * sink为最后的结果处理，负责数据入库或者日志等
 *
 *
 *
 */
package org.skynet.crawler.mall.gome;