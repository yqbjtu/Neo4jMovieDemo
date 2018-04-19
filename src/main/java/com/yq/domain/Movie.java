package com.yq.domain;

import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.DateString;


import java.util.Date;
/**
 *
 * @author yqbjtu
 * @version 2018/4/6 21:42
 */

@lombok.Data
@NodeEntity
public class Movie{
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String category;
    private Integer revenue;


    public Movie (String title, String category, int revenue) {
        this.title = title;
        this.category = category;
        this.revenue = revenue;
    }
    public Movie () {
    }
}
