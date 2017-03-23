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
            new SNCrawler().crawlerList("http://list.suning.com/0-20006-0.html", null, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
