package edu.hunau.service;

import com.github.pagehelper.PageInfo;
import edu.hunau.entity.ForumUser;

import java.util.List;

/**
 * 用户服务
 * 基础的增删改查
 * @author ND_LJQ
 * @date 2022/12/17
 */
public interface UserService {


//    DELETE-START

    /**
     * 用户删除
     *
     * @param userInfo 用户信息
     * @return boolean
     * @throws Exception 异常
     */
    public boolean userDelete(ForumUser userInfo) throws Exception;


//    INSERT-START

    /**
     * 用户插入
     *
     * @param userInfo 用户信息
     * @return boolean
     * @throws Exception 异常
     */
    public boolean userInsert(ForumUser userInfo) throws Exception;

    /**
     * 插入登录令牌
     *
     * @param token  令牌
     * @param userId 用户id
     * @return int
     * @throws Exception 异常
     */
    public int insertLoginToken(Integer userId,String token) throws Exception;



//    SELECT-START

    /**
     * 查询用户页面
     *
     * @param pageNum  页面号
     * @param pageSize 页面大小
     * @return {@link PageInfo}<{@link ForumUser}>
     * @throws Exception 异常
     */
    public PageInfo<ForumUser> queryUserByPage(Integer pageNum,Integer pageSize) throws Exception;


    /**
     * 通过id查询用户信息
     *
     * @param userId 用户id
     * @return {@link ForumUser}
     * @throws Exception 异常
     */
    public ForumUser queryUserById(Integer userId) throws Exception;


    /**
     * 查询用户通过电子邮件
     *
     * @param email 电子邮件
     * @return {@link ForumUser}
     * @throws Exception 异常
     */
    public ForumUser queryUserByEmail(String email) throws  Exception;

    /**
     * 通过电话查询用户
     *
     * @param tel 电话
     * @return {@link ForumUser}
     * @throws Exception 异常
     */
    public ForumUser queryUserByTel(String tel) throws Exception;



    //    UPDATE-START

    /**
     * 更新用户信息
     *
     * @param userInfo 用户信息
     * @return int
     * @throws Exception 异常
     */
    public int updateUserInfo(ForumUser userInfo) throws Exception;

    /**
     * 更新用户令牌
     *
     * @param userId 用户id
     * @return int
     * @throws Exception 异常
     */
    public int updateUserToken(Integer userId) throws Exception;

}
