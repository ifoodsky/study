package com.sky.mybatis;

import com.sky.mybatis.bean.Test;

public class BootStrap {
    public static void main(String[] args) {
        TSqlSession sqlSession = new TSqlSession(new TConfiguration(), new SimpleExecutor());
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectById(1);
        System.out.println(test);
        Test tempTest = testMapper.selectByName("张三");
        System.out.println(tempTest);
    }
}
