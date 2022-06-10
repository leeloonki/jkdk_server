package com.example.tools.service;


import com.example.tools.mapper.DietMapper;
import com.example.tools.pojo.Diet;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietService {
    @Autowired
    DietMapper dietMapper;
    public int InsertDiet(Diet diet){
        return dietMapper.InsertDiet(diet);
    }
    public List<Diet> SelectDiet(int uid,String ttime){return dietMapper.SelectDiet(uid,ttime);}
}
