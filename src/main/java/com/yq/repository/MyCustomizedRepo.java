/*
 * Copyright (C) 2018 org.citic.iiot, Inc. All Rights Reserved.
 */


package com.yq.repository;

import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

/**
 * Simple to Introduction
 * className: MyCustomizedRepo
 *
 * @author YangQian
 * @version 2018/4/18 19:42
 */
public class MyCustomizedRepo {

    @Autowired
    protected Neo4jTransactionManager transactionMgr;

    @Autowired
    protected SessionFactory sessionFactory;

    public void getAllPerson() {
        Session session = sessionFactory.openSession();
        try ( Transaction transaction = session.beginTransaction()) {
            String cql = "MATCH (n:DeviceCategoryV2)-[]->(s:*{isDelete:'0'}) return s,count(s) as count";
            Result result = session.query(cql, null);
            System.out.println("result:" + result);

            transaction.commit();
        } catch (Exception e) {
            throw  e;
        }



    }
}
