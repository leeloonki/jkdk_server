package com.example.tools.mapper;

import com.example.tools.pojo.Diet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DietMapper {
    int InsertDiet(Diet diet);
    List<Diet> SelectDiet(@Param("uid") int uid, @Param("ttime") String ttime);
}
