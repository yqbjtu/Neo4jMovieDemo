
package com.yq.repository;

import com.yq.domain.Movie;
import com.yq.domain.Person;

import java.io.Serializable;
import java.util.List;

/**
 * @author yqbjtu
 * @version 2018/4/19 8:59
 */
public interface CustomizedRepository <T>{
    List<T>  someCustomMethod();
    Iterable<T>  findByNodeId(Class<T> objectType, Integer id);

}