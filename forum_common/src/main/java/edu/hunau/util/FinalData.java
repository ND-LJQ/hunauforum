package edu.hunau.util;

/**
 * 最终数据
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
public class FinalData {
    /**
     * TOKEN 的默认过期时间
     */
    static final long TOKEN_EXPIRE_TIME = 30 * 60 * 1000;

    /**
     * 令牌钥匙
     */
    static final String TOKEN_SECRET = "ljqyyds";


//    响应状态码

    /**
     * 登录成功
     */
    public static final Integer LOGIN_SUCCESSFUL = 2001;

    /**
     * 注册成功
     */
    public static final Integer REGISTER_SUCCESSFUL = 2002;

    /**
     * 登录失败
     */
    public static final Integer LOGIN_FAILED = 4001;

    /**
     * 注册失败
     */
    public static final Integer REGISTER_FAILED = 4002;
}
