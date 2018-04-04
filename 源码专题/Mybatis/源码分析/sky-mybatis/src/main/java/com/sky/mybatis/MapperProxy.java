package com.sky.mybatis;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;

public class MapperProxy implements InvocationHandler {
    private TSqlSession sqlSession;

    public MapperProxy(TSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (TConfiguration.TestMapperXml.namespace.equals(method.getDeclaringClass().getName())) {
            Class<? extends Annotation> sqlAnnotationType = chooseAnnotationType(method);
            if (sqlAnnotationType != null){
                Annotation sqlAnnotation = method.getAnnotation(sqlAnnotationType);
                String statement = (String) sqlAnnotation.getClass().getMethod("value").invoke(sqlAnnotation);
                return sqlSession.selectOne(statement, args[0]);
            }
            return sqlSession.selectOne(TConfiguration.TestMapperXml.sqlMapperMap.get(method.getName()), args[0]);
        }
        return null;
    }

    private Class<? extends Annotation> chooseAnnotationType(Method method) {
        Set<Class<? extends Annotation>> sqlTypeSet = TConfiguration.TestMapperXml.sqlTypeSet;
        for (Class<? extends Annotation> type : sqlTypeSet) {
            if (method.getAnnotation(type) != null) {
                return type;
            }
        }
        return null;
    }
}
