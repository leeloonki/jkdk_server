package com.example.tools.controller;

import com.example.tools.pojo.Food;
import com.example.tools.service.FoodService;
import com.example.tools.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;
    private Result<List<Food>> foodResult = new Result<List<Food>>();

    @RequestMapping("/food/query")
    public Result<List<Food>> SignIn() {
        List<Food> foodList = foodService.SelectAllFood();
        System.out.println("------------------请求路径：" + "/food/query");
        System.out.println(foodList.toString());
        foodResult.setData(foodList);
        return foodResult;
    }
}
