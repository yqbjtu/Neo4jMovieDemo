package com.yq.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Properties;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yqbjtu
 * @version 2018/4/6 21:42
 */
@lombok.Data
//Entities handled by the OGM must have one empty public constructor to allow the library to construct the objects.
@NodeEntity
public class Person{
    @Id
    @GeneratedValue
    private Long id;

    //Fields on the entity are by default mapped to properties of the node
    private String firstName;
    private String lastName;
    private Integer height;

    public Person (String firstName, String lastName, int height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
    }
    public Person () {
    }
    @JsonIgnoreProperties("models")
    @Relationship(type = "ACTED_IN", direction = Relationship.OUTGOING)
    private List<Movie> aMovies;

    //也就是演员指向电影
    @Relationship(type = "DIRECTED", direction = Relationship.OUTGOING)
    private List<Movie> dMovies;

    public void addActMovie(Movie movie) {
        if (this.aMovies == null) {
            this.aMovies = new ArrayList<>();
        }
        this.aMovies.add(movie);
    }

    public void addDirectMovie(Movie movie) {
        if (this.dMovies == null) {
            this.dMovies = new ArrayList<>();
        }
        this.dMovies.add(movie);
    }
}
