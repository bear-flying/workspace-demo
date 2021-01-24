package com.jiangyu.mapper;

import com.jiangyu.pojo.OrderFood;

public interface OrderFoodMapper {

    int insert(OrderFood record);

    OrderFood selectByPrimaryKey(Integer id);

}