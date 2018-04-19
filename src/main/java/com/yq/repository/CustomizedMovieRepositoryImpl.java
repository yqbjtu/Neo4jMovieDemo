
package com.yq.repository;

import com.yq.domain.Movie;
import com.yq.domain.Person;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author yqbjtu
 * @version 2018/4/18 19:42
 */
@Repository
public class CustomizedMovieRepositoryImpl implements CustomizedMovieRepository {

    @Autowired
    protected Neo4jTransactionManager transactionMgr;

    @Autowired
    protected SessionFactory sessionFactory;

    public List<Movie> getAllMovie() {
        Session session = sessionFactory.openSession();
        List<Movie> movieList = new ArrayList<>();
        try ( Transaction transaction = session.beginTransaction()) {
            String cql = "MATCH (n:Movie)<-[]-(s) return n,count(s) as count";
            Map<String, String> map = new HashMap<>();
            Result result = session.query(cql, map);
            if (result != null) {
                Iterable<Map<String, Object>> itrMap = result.queryResults();
                int i = 0;
                for (Map<String, Object> tmpMap: itrMap) {
                    System.out.println(i + "th map");
                    Set<String> keySet = tmpMap.keySet();
                    for (String key : keySet) {
                        Object obj = tmpMap.get(key);
                        if (obj instanceof Movie) {
                            System.out.println("    add a movie obj:" + obj);
                            movieList.add((Movie)obj);
                        }
                        System.out.println("    Key:" + key + ", Value:" + obj);
                    }
                    i++;
                }
            }
            System.out.println("end result:" + result);

            transaction.commit();
        } catch (Exception e) {
            throw  e;
        }

        return movieList;
    }

    @Override
    public List<Movie> someCustomMethod() {
        return getAllMovie();
    }

    @Override
    public Iterable<Movie> findUseClassMethod(Integer id) {
        Session session = sessionFactory.openSession();
        Iterable<Movie> result = null;
        try ( Transaction transaction = session.beginTransaction()) {
            //String cql = "MATCH (n:Movie)<-[]-(s) WHERE n.id= $id return n";
            String cql = "MATCH (n:Movie)<-[]-(s) WHERE id(n)=$id  return n";
            Map<String, Integer> map = new HashMap<>();
            map.put("id", id);
            result = session.query(Movie.class, cql, map);
            System.out.println("end result:" + result);

            transaction.commit();
        } catch (Exception e) {
            throw  e;
        }

        return result;
    }
    /*
     *
     */
    @Override
    public Iterable<Person> findPersonMethod(String name) {
        Session session = sessionFactory.openSession();
        Iterable<Person> result = null;
        try ( Transaction transaction = session.beginTransaction()) {
            //String cql = "MATCH (n:Movie)<-[]-(s) WHERE n.id= $id return n";
            //MATCH (n:Person)-[]-(s) WHERE n.firstName=~'.*JingTia.*'  return n
            String cql = "MATCH (n:Person)-[]-(s) WHERE n.firstName=$name" +
                    " OR n.lastName=$name return n";
            Map<String, String> map = new HashMap<>();
            map.put("name", name);
            result = session.query(Person.class, cql, map);
            System.out.println("end result:" + result);

            transaction.commit();
        } catch (Exception e) {
            throw  e;
        }

        return result;
    }
}
