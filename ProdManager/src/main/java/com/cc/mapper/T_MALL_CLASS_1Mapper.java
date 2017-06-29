package com.cc.mapper;

import com.cc.entities.T_MALL_CLASS_1;
import java.util.List;

public interface T_MALL_CLASS_1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_MALL_CLASS_1 record);

    T_MALL_CLASS_1 selectByPrimaryKey(Integer id);

    List<T_MALL_CLASS_1> selectAll();

    int updateByPrimaryKey(T_MALL_CLASS_1 record);
}