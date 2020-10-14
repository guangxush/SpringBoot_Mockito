package com.shgx.mockito.model;

import java.io.Serializable;

/**
 * 基本服务上下文
 *
 * @author: guangxush
 * @create: 2020/09/26
 */
public class BaseServiceCtx implements Serializable {

    private static final long serialVersionUID = -2744706609822270974L;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
