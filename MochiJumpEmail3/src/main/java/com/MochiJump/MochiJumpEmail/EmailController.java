package com.MochiJump.MochiJumpEmail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class EmailController {
    @Autowired
    private JavaMailSender sender;
    @RequestMapping("/email/test")
    @ResponseBody
    String home() {
        try {
            sendEmail();
            return "success";
        }catch(Exception ex) {
            return "Error in sending email: "+ex;
        }
    }

    private void sendEmail() throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo("andrew.a.lenoir@gmail.com");
        helper.setText("This is a Spring App Generated Email");
        helper.setSubject("MochiJumpEmail Test");
        sender.send(message);

    }

}

