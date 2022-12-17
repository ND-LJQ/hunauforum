package edu.hunau.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static edu.hunau.util.FinalData.TOKEN_EXPIRE_TIME;
import static edu.hunau.util.FinalData.TOKEN_SECRET;

/**
 * 令牌工具类
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
public class TokenUtil {

    /**
     * 生成签名
     *
     * @param username  用户名
     * @return {@link String}
     */
    public  String sign(String username) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + TOKEN_EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("loginName", username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 验证
     *
     * @param token 令牌
     * @return boolean
     */
    public static boolean verify(String token){
        try {
            //设置签名的加密算法：HMAC256
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }




}
