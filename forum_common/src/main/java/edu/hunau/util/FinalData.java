package edu.hunau.util;

/**
 * 最终数据
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
public class FinalData {


    /**
     * 邮箱验证码位数
     */
    public static final int generateEmailVerificationCodeLength = 4;

    /**
     * 手机验证码位数
     */
    public static final int generatePhoneVerificationCodeLength = 6;

    /**
     * 邮箱验证码包含的字母和数字
     */
    public static final String[] EMAIL_META_CODE ={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /**
     * 手机验证码包含的数字
     */
    public static final String[] PHONE_META_CODE ={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};


    /**
     * 手机验证码过期时间
     * 单位为秒
     */
    public static final long PHONE_CODE_EXPIRY_TIME = 180;


    /**
     * PC端网页支付类型
     */
    public static final String PAY_TYPE_WEB_PC = "pc";

    /**
     * 移动端网页支付类型
     */
    public static final String PAY_TYPE_WEB_MOBILE = "mobile";

    /**
     * 应用程序支付类型
     */
    public static final String PAY_TYPE_WEB_APP = "app";

    public static final String SERVICE_TYPE_REGISTER = "注册账号";

    public static final String SERVICE_TYPE_LOGIN = "登录";

    public static final String SERVICE_TYPE_CHANGE_PASSWORD = "修改密码";

    public static final String SERVICE_TYPE_BACK_PASSWORD = "找回密码";
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
     * 插入成功
     */
    public static final Integer INSERT_SUCCESSFUL = 2005;


    /**
     * 令牌有效
     */
    public static final Integer TOKEN_EFFECTIVE = 2006;

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

    /**
     * 插入失败
     */
    public static final Integer INSERT_FAILED = 4006;

    /**
     * 令牌无效
     */
    public static final Integer TOKEN_INEFFECTIVE = 4006;


    /**
     * 图像保存路径
     */
    public static final String IMAGES_SAVE_PATH = "D:\\WorkSpace\\StudySpace\\Study-WORK\\Java\\Project\\hunauforum\\images";

    /**
     * 视频保存路径
     */
    public static final String VIDEO_SAVE_PATH = "D:\\WorkSpace\\StudySpace\\Study-WORK\\Java\\Project\\hunauforum\\video";


    /**
     * 搜索结果默认分页大小
     */
    public static final Integer SEARCH_PAGE_SIZE = 10;

}
