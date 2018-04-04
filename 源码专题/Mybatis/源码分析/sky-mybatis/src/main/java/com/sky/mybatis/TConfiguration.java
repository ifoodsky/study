package com.sky.mybatis;

import com.sky.mybatis.annotation.TSelect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TConfiguration {
    public <T> T getMapper(Class clazz, TSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{
                clazz}, new MapperProxy(sqlSession));
    }

    static class TestMapperXml {
        public static final String namespace = "com.sky.mybatis.TestMapper";
        public static final Map<String, String> sqlMapperMap = new HashMap<String, String>();
        public static final Set<Class<? extends Annotation>> sqlTypeSet = new HashSet<Class<? extends Annotation>>();

        static {
            sqlMapperMap.put("selectById", "select * from test where id = %d");
            sqlTypeSet.add(TSelect.class);
        }
    }
}
