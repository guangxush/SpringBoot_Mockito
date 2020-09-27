package com.shgx.mockito.model;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: guangxush
 * @create: 2020/09/27
 */
public class BaseServiceResult implements Serializable {
    private static final long serialVersionUID = 9108403094960343802L;

    private boolean isSuccess = false;

    private String resultCode;

    /**
     * 存放结果
     */
    private Map<String, Result> resultMap = Maps.newHashMap();

    /**
     * 扩展信息
     */
    private Map<String, String> extendInfo = Maps.newHashMap();

    public BaseServiceResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public BaseServiceResult(boolean isSuccess, String resultCode) {
        this.isSuccess = isSuccess;
        this.resultCode = resultCode;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Map<String, Result> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Result> resultMap) {
        this.resultMap = resultMap;
    }

    public Map<String, String> getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(Map<String, String> extendInfo) {
        this.extendInfo = extendInfo;
    }
}
