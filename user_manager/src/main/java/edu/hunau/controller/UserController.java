package edu.hunau.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import edu.hunau.entity.BackMessage;
import edu.hunau.entity.ForumUser;
import edu.hunau.service.UserService;
import edu.hunau.util.DateUtil;
import edu.hunau.util.TokenUtil;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Map;

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
    private UserService userService;
    TokenUtil tokenUtil = new TokenUtil();

    DateUtil dateUtil = new DateUtil();
    /**
     * 通过id获取用户信息
     *
     * @return {@link ForumUser}
     * @throws Exception 异常
     */
    @PostMapping(value = {"/{userId}"})
    public ForumUser getUserInfoById(@PathVariable Integer userId ) throws Exception{
        return this.userService.queryUserById(userId);
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
        MultipartHttpServletRequest params =((MultipartHttpServletRequest) request);
        String tel = params.getParameter("tel");
        String password = params.getParameter("password");
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
        MultipartHttpServletRequest params =((MultipartHttpServletRequest) request);
        String email = params.getParameter("email");
        String password = params.getParameter("password");
        ForumUser user = this.userService.queryUserByEmail(email);
        BackMessage back = new BackMessage();
        if(user!=null){
            if(password.equals(user.getPassword())){
                String token = tokenUtil.sign(email);
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
        MultipartHttpServletRequest params =((MultipartHttpServletRequest) request);
        String email = params.getParameter("email");
        String password = params.getParameter("password");
        ForumUser checkUser = this.userService.queryUserByEmail(email);
        BackMessage back = new BackMessage();
        if(checkUser!=null){
            back.setCode(REGISTER_FAILED);
            back.setMessage("注册失败,该邮箱已被注册!");
            return JSON.toJSONString(back);
        }

        Date date = dateUtil.getNowSqlDate();
        ForumUser user = new ForumUser();
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
        MultipartHttpServletRequest params =((MultipartHttpServletRequest) request);
        Integer tel = Integer.parseInt(params.getParameter("tel"));
        String password = params.getParameter("password");
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
        MultipartHttpServletRequest params = (MultipartHttpServletRequest) request;
        String password = params.getParameter("newPassword");
        String userId = params.getParameter("userId");
        ForumUser user = new ForumUser();
        BackMessage back = new BackMessage();
        user.setPassword(password);
        user.setUserId(Integer.valueOf(userId));
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
        MultipartHttpServletRequest params = (MultipartHttpServletRequest) request;
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
        BeanUtils.populate(user, params.getParameterMap());
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
    public String getUserInfo(@PathVariable Integer userId ) throws Exception{
        BackMessage back = new BackMessage();
        ForumUser user = this.userService.queryUserById(Integer.valueOf(userId));
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
