import org.junit.Test;
import org.skynet.crawler.mail.suning.SNCrawler;

/**
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/20
 */
public class CrawlerTest {
    @Test
    public void testSN(){
        new SNCrawler().crawler("");
    }
}
