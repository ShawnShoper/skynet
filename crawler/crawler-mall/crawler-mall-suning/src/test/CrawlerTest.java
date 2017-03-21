import org.junit.Test;
import org.skynet.crawler.mall.suning.SNCrawler;

import java.io.IOException;

/**
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/20
 */
public class CrawlerTest {
    @Test
    public void testSN(){
        try {
            SNCrawler snCrawler=new SNCrawler("D:/test/crawler/sn/");
            snCrawler.setThreads(100);
            snCrawler.start(1);
            snCrawler.visitAndGetNextLinks("http://shouji.suning.com/");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
