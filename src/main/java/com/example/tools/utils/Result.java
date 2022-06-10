package com.example.tools.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Result <T>{
    public int code;  //状态码
    public String msg; //返回信息
    public T data;
}
