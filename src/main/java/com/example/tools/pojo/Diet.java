package com.example.tools.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diet {
    private int did;
    private int uid;
    private int fid;
    private int bld;
    private String ttime;
    private int heatConsume;
}
