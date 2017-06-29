package com.cc.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author changcheng
 * @version 2017/6/28
 * @description
 */
public class MySqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory = null;
    private static String resource = "mybatis-config.xml";

    public static SqlSessionFactory getSqlSessionFactory() {
        InputStream inputStream = null;
        if (sqlSessionFactory == null) {

            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
            return sqlSessionFactory;
        } else {
            return sqlSessionFactory;
        }
    }
}
