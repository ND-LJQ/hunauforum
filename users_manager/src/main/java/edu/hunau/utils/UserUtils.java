package edu.hunau.utils;

import edu.hunau.util.MD5Utils;

/**
 * @author ND_LJQ
 * @date 2023/09/12
 */
public class UserUtils {
    /**
     * 检查用户密码是否正确
     * @param spwd 数据库中存储的密码
     * @param upwd 用户登录时的密码
     * @param salt 盐值
     * @return {@link Boolean}
     */
    public static Boolean checkPwd(String upwd,String spwd,String salt){
        System.out.println(spwd);
        System.out.println(upwd);
        System.out.println(MD5Utils.md5(upwd,salt));
        return spwd.equals(MD5Utils.md5(upwd,salt));
    }
}
