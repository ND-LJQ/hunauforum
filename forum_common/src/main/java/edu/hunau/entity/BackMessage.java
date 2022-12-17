package edu.hunau.entity;

/**
 * 返回消息实体类
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
public class BackMessage {
    private String message;

    private String token;

    private Integer code;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
