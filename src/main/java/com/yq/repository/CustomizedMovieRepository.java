
package com.yq.repository;

import com.yq.domain.Movie;
import com.yq.domain.Person;

import java.util.List;

/**
 * @author yqbjtu
 * @version 2018/4/19 8:59
 */
public interface CustomizedMovieRepository {
    List<Movie>  someCustomMethod();
    Iterable<Movie>  findUseClassMethod(Integer id);
    Iterable<Person>  findPersonMethod(String name);
}