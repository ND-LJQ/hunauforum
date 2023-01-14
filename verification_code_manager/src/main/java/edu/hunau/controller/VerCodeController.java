package edu.hunau.controller;

import edu.hunau.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static edu.hunau.util.FinalData.*;

@RestController
@RequestMapping(value = {"/vcode"})
public class VerCodeController {

    @Autowired
    VerificationCodeService verificationCodeService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping(value = {"/email"})
    public void sendEmail(@RequestParam("serviceType") String serviceType,@RequestParam("emailAddress") String emailAddress, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            switch(serviceType){
                case "1":
                    serviceType = SERVICE_TYPE_REGISTER;
                    break;
                case "2":
                    serviceType = SERVICE_TYPE_LOGIN;
                    break;
                case "3":
                    serviceType = SERVICE_TYPE_CHANGE_PASSWORD;
                    break;
                case "4":
                    serviceType = SERVICE_TYPE_BACK_PASSWORD;
                    break;
                default:
                    break;
            }
            char[] VerificationCode = verificationCodeService.generateVerificationCode(2).toCharArray();
            verificationCodeService.sendHtmlMail(emailAddress,"验证码",VerificationCode,serviceType);
            //获取存放在session域中的验证码
            System.out.println("session里的验证码："+VerificationCode);
//            后续将验证码添加到redis中

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @PostMapping(value = {"/tel"})
    public void sendTel(@RequestParam("phone") String phone,@RequestParam("serviceType") String serviceType){
        String VerificationCode = verificationCodeService.generateVerificationCode(2);
        this.verificationCodeService.sendTelVcode(phone,VerificationCode,serviceType);
    }



}
