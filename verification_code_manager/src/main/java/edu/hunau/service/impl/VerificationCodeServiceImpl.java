package edu.hunau.service.impl;

import edu.hunau.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import java.security.SecureRandom;

import static edu.hunau.util.FinalData.generateVerificationCodeLength;
import static edu.hunau.util.FinalData.metaCode;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {


    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    TemplateEngine templateEngine;

    /**
     * 从配置文件中获取发送人
     */
    @Value("${spring.mail.username}")
    private String sender;


    @Override
    public String generateVerificationCode() {
        SecureRandom random = new SecureRandom();
        StringBuilder verificationCode = new StringBuilder();
        while (verificationCode.length()<generateVerificationCodeLength){
            int i = random.nextInt(metaCode.length);
            verificationCode.append(metaCode[i]);
        }
        return verificationCode.toString();
    }

    @Override
    public void sendEmailVerCode(String receiver, String subject, String verCode) {

    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {

    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {

    }
}
