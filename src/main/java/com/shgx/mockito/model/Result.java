package com.shgx.mockito.model;

import java.util.Map;

/**
 * 执行结果
 *
 * @author: guangxush
 * @create: 2020/09/26
 */
public class Result {
    private ResultCodeEnum resultCodeEnum;
    private String errorMessage;
    /**
     * 扩展信息
     */
    private Map<String, Object> map;

    public Result(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
    }

    public Result(ResultCodeEnum resultCodeEnum, String errorMessage) {
        this.resultCodeEnum = resultCodeEnum;
        this.errorMessage = errorMessage;
    }

    public Result(ResultCodeEnum resultCodeEnum, String errorMessage, Map<String, Object> map) {
        this.resultCodeEnum = resultCodeEnum;
        this.errorMessage = errorMessage;
        this.map = map;
    }

    public ResultCodeEnum getResultCodeEnum() {
        return resultCodeEnum;
    }

    public void setResultCodeEnum(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCodeEnum=" + resultCodeEnum +
                ", errorMessage='" + errorMessage + '\'' +
                ", map=" + map +
                '}';
    }
}
