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
     * 更新成功
     */
    public static final Integer UPDATE_SUCCESSFUL = 2003;

    /**
     * 查询成功
     */
    public static final Integer SELECT_SUCCESSFUL = 2004;

    /**
     * 删除成功
     */
    public static final Integer DELETE_SUCCESSFUL = 2004;



    /**
     * 登录失败
     */
    public static final Integer LOGIN_FAILED = 4001;

    /**
     * 注册失败
     */
    public static final Integer REGISTER_FAILED = 4002;

    /**
     * 更新失败
     */
    public static final Integer UPDATE_FAILED = 4003;


    /**
     * 删除失败
     */
    public static final Integer DELETE_FAILED = 4004;

    /**
     * 查询失败
     */
    public static final Integer SELECT_FAILED = 4005;
}
