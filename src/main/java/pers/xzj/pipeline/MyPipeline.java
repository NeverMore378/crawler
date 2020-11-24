package pers.xzj.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.xzj.dao.Dao;
import pers.xzj.pojo.Article;
import pers.xzj.util.DownloadUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.awt.*;
import java.util.UUID;

/**
 * @author: xzj
 * @description: pipeline
 * @time: 2020-11-23 22:25
 */
@Component
public class MyPipeline implements Pipeline {

    @Autowired
    private Dao dao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Article article = new Article();
        article.setTitle(resultItems.get("title"));
        article.setImage(resultItems.get("image"));
        dao.save(article);
        try {
            DownloadUtil.download(resultItems.get("image"),UUID.randomUUID().toString()+".jpg","e:\\download");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
