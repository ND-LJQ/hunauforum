package edu.hunau.util;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.UUID;

/**
 * @author ND_LJQ
 */
public class MD5Utils {


    /**
     * 生成盐值
     * @return {@link String}
     */
    public static String generateSalt(){
        return UUID.randomUUID().toString();
    }

    /**
     * 生成HASH值
     * @param str 字符串
     * @param salt 盐值
     * @return {@link String}
     */
    public static String md5(String str, String salt) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            Base64.Encoder encoder = Base64.getEncoder();
            String saltedString = str + salt; // 将盐值与输入字符串组合
            byte[] encode = encoder.encode(instance.digest(saltedString.getBytes("utf-8")));
            return new String(encode,"utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}