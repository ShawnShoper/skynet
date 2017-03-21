
package org.skynet.crawler;

import cn.edu.hfut.dmic.webcollector.crawler.DeepCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import org.jsoup.nodes.Document;

/**
 * 电商爬虫
 * @author zhangxuh
 * @email zhangxuh.mvp@qq.com
 * @date 2017/3/20
 */
public abstract class EBCrawler extends DeepCrawler{

    public  EBCrawler(String crawlPath){
        super(crawlPath);
    }
    @Override
    public Links visitAndGetNextLinks(Page page) {
        Links nextLinks = new Links();
        String contentType=page.getResponse().getContentType();
        if(contentType!=null&&contentType.contains("text/html")){
            Document doc=page.getDoc();
            if (doc!=null){
                nextLinks.addAllFromDocument(doc);
            }
            visit(page,nextLinks);
        }
        return nextLinks;
    }
    public Links visitAndGetNextLinks(String url) throws Exception {
        return visitAndGetNextLinks(getPage(url));
    }

    /**
     * 根据url获取Page实例
     *
     * @param url
     * @return
     * @throws Exception
     */
    private Page getPage(String url) throws Exception {
        HttpRequest httpRequest = new HttpRequest(url);
        HttpResponse response = httpRequest.getResponse();
        Page page = new Page();
        page.setUrl(url);
        page.setHtml(response.getHtmlByCharsetDetect());
        page.setResponse(response);
        return page;
    }

    public abstract void visit(Page page, Links links);
}
