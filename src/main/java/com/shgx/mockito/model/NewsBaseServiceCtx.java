package com.shgx.mockito.model;

import java.io.Serializable;

/**
 * @author: guangxush
 * @create: 2020/09/26
 */
public class NewsBaseServiceCtx extends BaseServiceCtx implements Serializable {
    private static final long serialVersionUID = 6315523461603858894L;
    /**
     * 新闻话题
     */
    private String topic;
    /**
     * 新闻内容
     */
    private String message;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
