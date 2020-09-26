package com.shgx.mockito.model;

/**
 * @author: guangxush
 * @create: 2020/09/26
 */
public enum ResultCodeEnum {
    /**
     * 成功
     */
    SUCCESS("success", "成功"),

    /**
     * 失败
     */
    FAILURE("fail", "失败");

    private String code;

    private String desc;

    ResultCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ResultCodeEnum{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
