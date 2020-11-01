package com.shgx.mockito.model;

/**
 * @author: guangxush
 * @create: 2020/11/01
 */
public class AlgorithmDO {
    /**
     * 算法ID
     */
    private String id;
    /**
     * 算法名称
     */
    private String name;
    /**
     * 算法版本
     */
    private String version;
    /**
     * 算法入参
     */
    private String param;
    /**
     * 算法结果
     */
    private Boolean result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
