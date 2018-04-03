package com.sky.mybatis;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class TConfiguration {
    public <T> T getMapper(Class clazz, TSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{
                clazz}, new MapperProxy(sqlSession));
    }

    static class TestMapperXml {
        public static final String namespace = "com.sky.mybatis.TestMapper";
        public static final Map<String, String> sqlMapperMap = new HashMap<String, String>();

        static {
            sqlMapperMap.put("selectById", "select * from test where id = %d");
        }
    }
}
