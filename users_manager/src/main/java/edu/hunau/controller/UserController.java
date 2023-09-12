package edu.hunau.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import com.github.yitter.idgen.YitIdHelper;
import edu.hunau.entity.BackMessage;
import edu.hunau.entity.ForumUser;
import edu.hunau.repository.RedisRepository;
import edu.hunau.service.UserService;
import edu.hunau.util.DateUtil;
import edu.hunau.util.MD5Utils;
import edu.hunau.util.TokenUtil;
import edu.hunau.utils.UserUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import static edu.hunau.util.FinalData.*;


/**
 * 用户控制方法
 * @author ND_LJQ
 * @date 2022/12/17
 */

@RestController
@RequestMapping("/forumuser")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private  UserService userService;

    @Autowired
    private RedisRepository redisRepository;

    TokenUtil tokenUtil = new TokenUtil();

    DateUtil dateUtil = new DateUtil();
    /**
     * 通过id获取用户信息
     *
     * @return {@link ForumUser}
     * @throws Exception 异常
     */

    @PostMapping(value = {"/{userId}"})
    public ForumUser getUserInfoById(@PathVariable String userId ) throws Exception{
        return this.userService.queryUserById(Long.valueOf(userId));
    }


    /**
     * 使用电话为账号登录
     *
     * @param request 请求
     * @return {@link String}
     * @throws Exception 异常
     */

    @PostMapping(value = {"/login/tel"})
    public BackMessage userLoginByTel(HttpServletRequest request) throws Exception{
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        ForumUser user = this.userService.queryUserByTel(tel);
        if(user!=null){
            if(UserUtils.checkPwd(password,user.getPassword(),user.getSalt())){
                String token = tokenUtil.sign(tel);
                BackMessage backMessage = new BackMessage("登录成功!",token,LOGIN_SUCCESSFUL);
                this.userService.insertLoginToken(user.getUserId(),token);
                return backMessage;
            }
            return new BackMessage("密码错误!",LOGIN_FAILED);
        }else {
            return new BackMessage("账号错误!",LOGIN_FAILED);
        }
    }


    /**
     * 用户使用手机验证码登录
     * @param request
     * @return {@link String}
     * @throws Exception
     */
    @PostMapping(value = {"/login/tel/code"})
    public BackMessage userLoginByTelCode(HttpServletRequest request) throws Exception {
        String tel = request.getParameter("tel");
        String code = request.getParameter("code");
        ForumUser user = userService.queryUserByTel(tel);
        String resultCode = redisRepository.getStringValue(tel).toString();

        if (code.equals(resultCode)){
            String token = tokenUtil.sign(tel);
            BackMessage back = new BackMessage("登录成功!",token,LOGIN_SUCCESSFUL);
            this.userService.insertLoginToken(user.getUserId(),token);
            return back;
        }else {
            return new BackMessage("验证码错误!",LOGIN_FAILED);
        }
    }


    /**
     * 通过电子邮件作为账号登录
     *
     * @param request 请求
     * @return {@link String}
     * @throws Exception 异常
     */

    @PostMapping(value = {"/login/email"})
    @ResponseBody
    public BackMessage userLoginByEmail(HttpServletRequest request) throws Exception{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ForumUser user = this.userService.queryUserByEmail(email);
        if(user!=null){
            if(UserUtils.checkPwd(password,user.getPassword(),user.getSalt())){
                String token = tokenUtil.sign(email);
                BackMessage back = new BackMessage("登录成功!",token,LOGIN_SUCCESSFUL,user);
                this.userService.insertLoginToken(user.getUserId(),token);
                return back;
            }
            return new BackMessage("密码错误!",LOGIN_SUCCESSFUL);
        }else {
            return new BackMessage("账号错误!",LOGIN_FAILED);
        }

    }


    /**
     * 用户通过电子邮件注册
     *
     * @param request 请求
     * @return {@link String}
     * @throws Exception 异常
     */

    @PostMapping(value = {"/register/mail"})
    @ResponseBody
    public BackMessage userRegisterByEmail(HttpServletRequest request) throws Exception{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ForumUser checkUser = this.userService.queryUserByEmail(email);
        if(checkUser!=null){
            return new BackMessage("注册失败,该邮箱已被注册!",REGISTER_FAILED);
        }
        long newId = YitIdHelper.nextId();
        Date date = dateUtil.getNowSqlDate();
        String salt = MD5Utils.generateSalt();
        // 这里的state为用户账号状态0为启用1为禁用,标记一下防止magic number
        ForumUser user = new ForumUser(newId,email,MD5Utils.md5(password,salt),date,salt,0);
        boolean result = this.userService.userInsert(user);
        if(result){
            return new BackMessage("注册成功!",REGISTER_SUCCESSFUL);
        }else{
            return new BackMessage("注册失败,请检查网络是否有问题",REGISTER_FAILED);
        }
    }


    /**
     * 用户通过电话注册
     *
     * @param request 请求
     * @return {@link String}
     * @throws Exception 异常
     */

    @PostMapping(value = {"/register/tel"})
    @ResponseBody
    public BackMessage userRegisterByTel(HttpServletRequest request) throws Exception{
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        ForumUser checkUser = this.userService.queryUserByTel(String.valueOf(tel));
        if(checkUser!=null){
            return new BackMessage("注册失败,该电话已被注册!",REGISTER_FAILED);
        }
        long newId = YitIdHelper.nextId();
        Date date = dateUtil.getNowSqlDate();
        String salt = MD5Utils.generateSalt();
        // 这里的state为用户账号状态0为启用1为禁用,标记一下防止magic number
        ForumUser user = new ForumUser(newId,MD5Utils.md5(password,salt),date,salt,tel,0);
        boolean result = this.userService.userInsert(user);
        if(result){
            return new BackMessage("注册成功!",REGISTER_SUCCESSFUL);
        }else{
            return new BackMessage("注册失败,请检查网络是否有问题",REGISTER_FAILED);
        }
    }


    @GetMapping(value = {"/queryToken/{token}"})
    public BackMessage checkToken(@PathVariable String token){
        System.out.println(token);
        Boolean result = TokenUtil.verify(token);
        if (result){
            return new BackMessage("登录信息有效",TOKEN_EFFECTIVE);
        }else {
            return new BackMessage("登录信息失效,请重新登录",TOKEN_INEFFECTIVE);
        }
    }


    /**
     * 更改用户密码
     *
     * @param request 请求
     * @return {@link String}
     * @throws Exception 异常
     */

    @PostMapping(value = {"/changepwd"})
    @ResponseBody
    public BackMessage changeUserPwd(HttpServletRequest request) throws Exception{
        String password = request.getParameter("newPassword");
        String userId = request.getParameter("userId");
        ForumUser user = new ForumUser();
        user.setPassword(password);
        user.setUserId(Long.valueOf(userId));
        Integer result =  this.userService.updateUserInfo(user);
        if(result==1){
            return new BackMessage("修改成功!",UPDATE_SUCCESSFUL);
        }else{
            return new BackMessage("修改失败,服务器繁忙!",UPDATE_FAILED);
        }
    }


    /**
     * 修改用户信息
     *
     * @param request 请求
     * @return {@link String}
     * @throws Exception 异常
     */

    @PostMapping(value = {"/changeinfo"})
    @ResponseBody
    public BackMessage changeUserInfo(HttpServletRequest request) throws Exception{
//        遍历Map的方法
//        1.map的entry
//        for(Map.Entry item : params.getParameterMap().entrySet()){
//            item.getKey();
//            item.getValue();
//        }
//        2.java8的lambda
        BackMessage back = new BackMessage();
        ForumUser user = new ForumUser();
        //将map中的值赋值给
        BeanUtils.populate(user, request.getParameterMap());
        if(this.userService.updateUserInfo(user)==1){
            return new BackMessage("修改成功!",UPDATE_SUCCESSFUL);
        }else{
            return new BackMessage("修改失败!系统繁忙,请稍后修改!",UPDATE_FAILED);
        }
    }

    /**
     * 获取用户信息
     *
     * @param userId 用户id
     * @return {@link String}
     * @throws Exception 异常
     */

    @GetMapping(value = {"/user/{userId}"})
    public BackMessage getUserInfo(@PathVariable String userId ) throws Exception{
        long newId = YitIdHelper.nextId();
        ForumUser user = this.userService.queryUserById(Long.valueOf(userId));
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().add("password");
        String userInfo = JSON.toJSONString(user,filter);
        BackMessage back = new BackMessage("查询成功!",SELECT_SUCCESSFUL,JSONObject.parseObject(userInfo));
        return back;
    }



    //接受POST form-data格式的请求

    @PostMapping(value = {"/test"})
    @ResponseBody
    public String test(HttpServletRequest request){
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        String string = params.getParameter("test1");
        System.out.println(string);
        return "";
    }

}
