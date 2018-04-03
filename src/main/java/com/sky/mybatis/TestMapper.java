package com.sky.mybatis;

import com.sky.mybatis.bean.Test;

public interface TestMapper {
    Test selectById(Integer id);
}
