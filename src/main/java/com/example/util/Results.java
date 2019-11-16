package com.example.util;

import lombok.Data;

/**
 * Created by chenlin on 2019/11/16.
 * 自定义接口返回模板
 */
@Data
public class Results {
    private String code;
    private String msg;
    private Object data;
    private boolean success;

    /**成功模板*/
    public static Results success(Object data){
        Results results = new Results();
        results.setCode("200");
        results.setMsg("成功");
        results.setData(data);
        results.setSuccess(true);
        return results;
    }

    /**失败模板*/
    public static Results fail(String failCode,String msg){
        Results results = new Results();
        results.setCode(failCode);
        results.setMsg(msg);
        results.setSuccess(false);
        return results;
    }
}
