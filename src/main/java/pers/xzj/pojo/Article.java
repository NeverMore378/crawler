package pers.xzj.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author: xzj
 * @description: pojo
 * @time: 2020-11-23 22:27
 */

@Data
@Entity
public class Article implements Serializable {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private String id;
    private String title;
    private String image;

}
