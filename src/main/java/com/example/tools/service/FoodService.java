package com.example.tools.service;

import com.example.tools.mapper.FoodMapper;
import com.example.tools.pojo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodMapper foodMapper;

    public List<Food> SelectAllFood(){
        return foodMapper.SelectAll();
    }

}
