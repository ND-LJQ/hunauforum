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
import edu.hunau.util.TokenUtil;
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
    public String userLoginByTel(HttpServletRequest request) throws Exception{
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        ForumUser user = this.userService.queryUserByTel(tel);
        BackMessage back = new BackMessage();
        if(user!=null){
            if(password.equals(user.getPassword())){
                String token = tokenUtil.sign(tel);
                back.setCode(LOGIN_SUCCESSFUL);
                back.setMessage("登录成功!");
                back.setToken(token);
                this.userService.insertLoginToken(user.getUserId(),token);
                return JSON.toJSONString(back);
            }
            back.setCode(LOGIN_FAILED);
            back.setMessage("密码错误!");
        }else {
            back.setCode(LOGIN_FAILED);
            back.setMessage("账号错误!");
        }
        return JSON.toJSONString(back);
    }


    @PostMapping(value = {"/login/tel/code"})
    public String userLoginByTelCode(HttpServletRequest request) throws Exception {
        String tel = request.getParameter("tel");
        String code = request.getParameter("code");
        ForumUser user = userService.queryUserByTel(tel);
        String resultCode = redisRepository.getStringValue(tel).toString();
        BackMessage back = new BackMessage();
        if (code.equals(resultCode)){
            String token = tokenUtil.sign(tel);
            back.setCode(LOGIN_SUCCESSFUL);
            back.setMessage("登录成功!");
            back.setToken(token);
            this.userService.insertLoginToken(user.getUserId(),token);
            return JSON.toJSONString(back);
        }else {
            back.setCode(LOGIN_FAILED);
            back.setMessage("验证码错误!");
        }
        return JSON.toJSONString(back);
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
    public String userLoginByEmail(HttpServletRequest request) throws Exception{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ForumUser user = this.userService.queryUserByEmail(email);
        BackMessage back = new BackMessage();
        if(user!=null){
            if(password.equals(user.getPassword())){
                String token = tokenUtil.sign(email);
                back.setCode(LOGIN_SUCCESSFUL);
                back.setMessage("登录成功!");
                back.setToken(token);
                back.setData(user);
                this.userService.insertLoginToken(user.getUserId(),token);
                return JSON.toJSONString(back);
            }
            back.setCode(LOGIN_FAILED);
            back.setMessage("密码错误!");

        }else {
            back.setCode(LOGIN_FAILED);
            back.setMessage("账号错误!");
        }
        return JSON.toJSONString(back);
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
    public String userRegisterByEmail(HttpServletRequest request) throws Exception{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email);
        System.out.println(password);
        ForumUser checkUser = this.userService.queryUserByEmail(email);
        BackMessage back = new BackMessage();
        if(checkUser!=null){
            back.setCode(REGISTER_FAILED);
            back.setMessage("注册失败,该邮箱已被注册!");
            return JSON.toJSONString(back);
        }
        long newId = YitIdHelper.nextId();
        Date date = dateUtil.getNowSqlDate();

        ForumUser user = new ForumUser();
        user.setUserId(newId);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreateTime(date);

        boolean result = this.userService.userInsert(user);
        if(result){
            back.setCode(REGISTER_SUCCESSFUL);
            back.setMessage("注册成功!");
        }else{
            back.setCode(REGISTER_FAILED);
            back.setMessage("注册失败,请检查网络是否有问题");
        }
        return JSON.toJSONString(back);
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
    public String userRegisterByTel(HttpServletRequest request) throws Exception{
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        ForumUser checkUser = this.userService.queryUserByTel(String.valueOf(tel));
        BackMessage back = new BackMessage();
        if(checkUser!=null){
            back.setCode(REGISTER_FAILED);
            back.setMessage("注册失败,该邮箱已被注册!");
            return JSON.toJSONString(back);
        }

        Date date = dateUtil.getNowSqlDate();

        ForumUser user = new ForumUser();
        user.setTel(tel);
        user.setPassword(password);
        user.setCreateTime(date);
        boolean result = this.userService.userInsert(user);

        if(result){
            back.setCode(REGISTER_SUCCESSFUL);
            back.setMessage("注册成功!");
        }else{
            back.setCode(REGISTER_FAILED);
            back.setMessage("注册失败,请检查网络是否有问题");
        }
        return JSON.toJSONString(back);
    }


    @GetMapping(value = {"/queryToken/{token}"})
    public String checkToken(@PathVariable String token){
        BackMessage backMessage = new BackMessage();
        System.out.println(token);
        Boolean result = TokenUtil.verify(token);
        if (result){
            backMessage.setCode(TOKEN_EFFECTIVE);
            backMessage.setMessage("登录信息有效");
            return JSON.toJSONString(backMessage);
        }else {
            backMessage.setCode(TOKEN_INEFFECTIVE);
            backMessage.setMessage("登录信息失效,请重新登录");
            return JSON.toJSONString(backMessage);
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
    public String changeUserPwd(HttpServletRequest request) throws Exception{
        String password = request.getParameter("newPassword");
        String userId = request.getParameter("userId");
        ForumUser user = new ForumUser();
        BackMessage back = new BackMessage();
        user.setPassword(password);
        user.setUserId(Long.valueOf(userId));
        Integer result =  this.userService.updateUserInfo(user);
        if(result==1){
            back.setCode(UPDATE_SUCCESSFUL);
            back.setMessage("修改成功!");
        }else{
            back.setCode(UPDATE_FAILED);
            back.setMessage("修改失败,服务器繁忙!");
        }
        return JSON.toJSONString(back);
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
    public String changeUserInfo(HttpServletRequest request) throws Exception{
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
            back.setCode(UPDATE_SUCCESSFUL);
            back.setMessage("修改成功!");
        }else{
            back.setCode(UPDATE_SUCCESSFUL);
            back.setMessage("修改失败!系统繁忙,请稍后修改!");
        }
        return JSON.toJSONString(back);
    }

    /**
     * 获取用户信息
     *
     * @param userId 用户id
     * @return {@link String}
     * @throws Exception 异常
     */

    @GetMapping(value = {"/user/{userId}"})
    public String getUserInfo(@PathVariable String userId ) throws Exception{
        long newId = YitIdHelper.nextId();
        BackMessage back = new BackMessage();
        ForumUser user = this.userService.queryUserById(Long.valueOf(userId));
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().add("password");
        String userInfo = JSON.toJSONString(user,filter);
        back.setData(JSONObject.parseObject(userInfo));
        back.setCode(SELECT_SUCCESSFUL);
        back.setMessage("查询成功!");
        return JSON.toJSONString(back);
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
