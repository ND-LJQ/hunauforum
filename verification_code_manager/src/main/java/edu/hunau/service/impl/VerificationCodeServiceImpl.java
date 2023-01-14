package edu.hunau.service.impl;

import edu.hunau.config.TxSmsProperties;
import edu.hunau.service.VerificationCodeService;
import edu.hunau.util.TxSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.security.SecureRandom;

import static edu.hunau.util.FinalData.*;

/**
 * 验证码服务impl
 *
 * @author ND_LJQ
 * @date 2023/01/06
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {


    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    TemplateEngine templateEngine;

    TxSmsProperties properties = new TxSmsProperties();

    TxSmsUtil txSmsUtil = new TxSmsUtil();

    private final Integer EMAIL_CODE = 2;
    private final Integer PHONE_CODE = 1;
    /**
     * 从配置文件中获取发送人
     */
    @Value("${spring.mail.username}")
    private String sender;


    @Override
    public String generateVerificationCode(Integer type) {
        SecureRandom random = new SecureRandom();
        StringBuilder verificationCode = new StringBuilder();
        if(type.equals(EMAIL_CODE)){
            while (verificationCode.length()<generateEmailVerificationCodeLength){
                int i = random.nextInt(EMAIL_META_CODE.length);
                verificationCode.append(EMAIL_META_CODE[i]);
            }
        } else if (type.equals(PHONE_CODE)) {
            while (verificationCode.length()<generatePhoneVerificationCodeLength){
                int i = random.nextInt(PHONE_META_CODE.length);
                verificationCode.append(PHONE_META_CODE[i]);
            }
        }
        return verificationCode.toString();
    }

    @Override
    public void sendEmailVerCode(String receiver, String subject, String verCode) throws MailSendException {
        SimpleMailMessage message = new SimpleMailMessage();
        //设置邮件标题
        message.setSubject("验证码");
        message.setText("尊敬的用户,您好:\n"
                + "\n本次请求的邮件验证码为:\n<span>" + verCode + "</span>,本验证码5分钟内有效，请及时输入。（请勿泄露此验证码）\n"
                + "\n如非本人操作，请忽略该邮件。\n(这是一封自动发送的邮件，请不要直接回复）");	//设置邮件正文
        //设置收件人
        message.setTo(receiver);
        //设置发件人
        message.setFrom(sender);
        //发送邮件
        mailSender.send(message);
    }

    @Override
    public void sendHtmlMail(String to, String subject, char[] content, String serviceType) {
        //获取MimeMessage对象
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message, true);
            //邮件发送人
            messageHelper.setFrom(sender);
            //邮件接收人
            messageHelper.setTo(to);
            //邮件主题
            message.setSubject(subject);
            Context context = new Context();
            //设置传入模板的页面的参数 参数名为:id 参数随便写一个就行
            context.setVariable("message", content);
            context.setVariable("serviceType", serviceType);
            //emailTemplate是你要发送的模板我这里用的是Thymeleaf
            String process = templateEngine.process("emailTemplate", context);
            //邮件内容，html格式
            messageHelper.setText(process, true);
            //发送
            mailSender.send(message);
            //日志信息
//            log.info("邮件已经发送。");
        } catch (Exception e) {
//            log.error("发送邮件时发生异常！", e);
        }
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            //日志信息
//            log.info("邮件已经发送。");
        } catch (Exception e) {
//            log.error("发送邮件时发生异常！", e);
        }
    }

    @Override
    public void sendTelVcode(String phone,String code,String serviceType) {
        txSmsUtil.sendSms(properties,phone,code);
    }
}
