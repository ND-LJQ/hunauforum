package edu.hunau.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 返回消息实体类
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
//RestController返回Json格式时排除该对象中值为空的属性
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BackMessage {
    private String message;

    private String token;

    private Integer code;

    private  Object  data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


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

    public BackMessage(){}

    public BackMessage(String message,Integer code){
        this.message = message;
        this.code = code;
    }

    public BackMessage(String message, String token, Integer code, Object data) {
        this.message = message;
        this.token = token;
        this.code = code;
        this.data = data;
    }

    public BackMessage(String message, String token, Integer code) {
        this.message = message;
        this.token = token;
        this.code = code;
    }

    public BackMessage(String message, Integer code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
