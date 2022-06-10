package com.example.tools.mapper;

import com.example.tools.pojo.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {
    //    后台增加
    List<Food> SelectAll();
}

