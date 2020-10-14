package com.shgx.mockito.model;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 动作执行结果
 *
 * @author: guangxush
 * @create: 2020/09/27
 */
public class ActionResult {
    private Map<ResultCodeEnum, String> extendInfo = Maps.newHashMap();

    public ActionResult() {
    }

    public ActionResult(Map<ResultCodeEnum, String> extendInfo) {
        this.extendInfo = extendInfo;
    }

    public Map<ResultCodeEnum, String> getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(Map<ResultCodeEnum, String> extendInfo) {
        this.extendInfo = extendInfo;
    }
}
