package com.lushuai.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtils {
    private static SqlSessionFactory factory = null;
    static {
        Reader resourceAsReader = null;
        try {
            resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(resourceAsReader);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSession(){
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }
}
