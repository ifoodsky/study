package com.sky.mybatis;

public interface TExecutor {
    <T> T query(String statement, Object parameter);
}
