package com.sky.mybatis;

import com.sky.mybatis.annotation.TSelect;
import com.sky.mybatis.bean.Test;

public interface TestMapper {
    Test selectById(Integer id);

    @TSelect("select * from test where name = '%s'")
    Test selectByName(String name);
}
