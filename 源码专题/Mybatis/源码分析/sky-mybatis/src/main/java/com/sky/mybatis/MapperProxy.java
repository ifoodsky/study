package com.sky.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {
    private TSqlSession sqlSession;

    public MapperProxy(TSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (TConfiguration.TestMapperXml.namespace.equals(method.getDeclaringClass().getName())) {
            return sqlSession.selectOne(TConfiguration.TestMapperXml.sqlMapperMap.get(method.getName()), args[0]);
        }
        return null;
    }
}
