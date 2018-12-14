package com.MochiJump.mochijumpemail;

import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class EmailController {
	private ObjectMapper mapper = new ObjectMapper();
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
    private void sendActivationEmail(Message m) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(m.getEmail());
        helper.setBcc("andrew.a.lenoir@gmail.com");
        helper.setText(m.getMessageBody());
        helper.setSubject(m.getSubject());
        sender.send(message);

    }
    
    private void sendEmailParam(Message m) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo("andrew.a.lenoir@gmail.com");
        helper.setText(m.getMessageBody()+ " from " + m.getEmail());
        helper.setSubject(m.getSubject()+" From: "+m.getEmail());
        sender.send(message);

    }
    
    @PostMapping("/email/message")
    public @ResponseBody String interpertMessage(@RequestBody String s) {
    	Message m;
    	try {
    		m = mapper.readValue(s, Message.class);
    		} catch (JsonMappingException e) {
    		    e.printStackTrace();
    		    return "fail" + e;
    		} catch (JsonGenerationException e) {
    		    e.printStackTrace();
    		    return "fail" + e;
    		} catch (IOException e) {
    		    e.printStackTrace();
    		    return "fail" + e;
    		}
    	try{
    		sendEmailParam(m);
    		return "success!";
    	}catch (Exception e) {
    		return "sendEmailParam parameter is null";
    	}
    	
    }
    
    @PostMapping("/email/activateNewAccount")
    public @ResponseBody String activateAccount(@RequestBody String s) {
    	Message m;
    	try {
    		m = mapper.readValue(s, Message.class);
    		} catch (JsonMappingException e) {
    		    e.printStackTrace();
    		    return "fail" + e;
    		} catch (JsonGenerationException e) {
    		    e.printStackTrace();
    		    return "fail" + e;
    		} catch (IOException e) {
    		    e.printStackTrace();
    		    return "fail" + e;
    		}
    	try{
    		sendActivationEmail(m);
    		return "success!";
    	}catch (Exception e) {
    		return "sendEmailParam parameter is null";
    	}
    	
    }

}


