package com.example.tools.controller;


import com.example.tools.pojo.Diet;
import com.example.tools.pojo.Food;
import com.example.tools.pojo.User;
import com.example.tools.service.DietService;
import com.example.tools.service.UserService;
import com.example.tools.utils.Result;
import com.example.tools.vo.queryDiet;
import com.example.tools.vo.voDiet;
import com.example.tools.vo.voUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DietController {
    @Autowired
    DietService dietService;
    Result<List<Diet>> listResult = new Result<>();
    @RequestMapping("/diet/insert")
    public Result<Diet> SignIn(@RequestBody voDiet voDiet) {
        Result<Diet> dietResult = new Result<Diet>();
        Diet diet = new Diet();
        diet.setUid(voDiet.uid);
        diet.setFid(voDiet.fid);
        diet.setBld(voDiet.bld);
        diet.setTtime(voDiet.ttime);
        diet.setHeatConsume(voDiet.heatConsume);
        if(1==dietService.InsertDiet(diet)){
            dietResult.setMsg("添加成功");
            dietResult.setCode(200);
        }else{
            dietResult.setMsg("添加失败");
            dietResult.setCode(400);
        }
        dietResult.setData(null);
        System.out.println("------------------请求路径："+"/diet/insert");
        return dietResult;
    }

    @RequestMapping("/diet/query")
    public Result<List<Diet>> Query(queryDiet diet) {
        listResult.data = dietService.SelectDiet(diet.uid,diet.ttime);
        System.out.println("------------------请求路径：" + "/diet/query");
//        System.out.println(listResult.data.toString());
        listResult.setCode(200);
        listResult.setMsg("查询成功");
        return listResult;
    }
}
