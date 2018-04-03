package com.sky.mybatis;


public class TSqlSession {
    private TConfiguration configuration;
    private TExecutor executor;

    public TSqlSession(TConfiguration configuration, TExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class clazz) {
        return configuration.getMapper(clazz, this);
    }

    public <T> T selectOne(String statement, Object parameter) {
        return executor.query(statement, parameter);
    }
}
