package com.myself.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    //可能data is null 定义两个参数的构造
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
