package pers.xzj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.xzj.pojo.Article;

/**
 * @author: xzj
 * @description: dao
 * @time: 2020-11-23 22:25
 */
public interface Dao extends JpaRepository<Article,String> {
}
