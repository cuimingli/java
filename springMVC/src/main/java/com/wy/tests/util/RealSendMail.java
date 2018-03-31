package com.wy.tests.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RealSendMail {
	
	public static void sendEmail(String email){
		try{
          Properties props = new Properties();	
           props.put("username", "13732283597");
           props.put("password", "ming123456");
           props.put("mail.transport.protocol", "smtp");
           props.put("mail.smtp.host", "smtp.139.com");
           props.put("mail.smtp.port", "25");
           Session mailSession  = Session.getDefaultInstance(props);
           Message msg = new MimeMessage(mailSession);
           msg.setFrom(new InternetAddress("13732283597@139.com"));
           String emial = email.trim();
           msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emial));   
           msg.setSubject("来自送鸟商城的激活邮件");
           msg.setContent("<h1>此邮件为送鸟商城激活邮件！请点击下面链接完成激活操作！</h1><h3><a href='http://localhost:8080/view/reg.html?code="+emial+"'><h3>请点击此处<h3></a></h3>","text/html;charset=UTF-8");
		   msg.saveChanges();
		   Transport transport = mailSession.getTransport("smtp");
		   transport.connect(props.getProperty("mail.smtp.host"), props.getProperty("username"), 
				   props.getProperty("password"));
		   transport.sendMessage(msg, msg.getAllRecipients());
		   transport.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
