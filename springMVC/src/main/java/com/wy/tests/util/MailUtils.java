package com.wy.tests.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {
	/**
	 * 
	 * @param to  给谁发邮件
	 * @param code 邮件的激活码
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
     public static void sendMail(String to,String code) throws AddressException, MessagingException{
    	 //创建链接对象，链接到邮箱服务器
    	 Properties props = new Properties();
    	// props.setProperty("host", arg1)
    	 //主机名，服务器地址
    	 
    	 Session session = Session.getInstance(props, new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("service@store","123");
			}
    	 });
    	 
    	 //创建邮箱对象
    	 Message message = new MimeMessage(session);
    	 //设置发件人
    	 message.setFrom(new InternetAddress("service@store"));
    	 //设置收件人
    	 message.setRecipient(RecipientType.TO, new InternetAddress(to));
    	 //设置邮件的主题
    	 message.setSubject("来自送鸟的激活邮件");
    	 //设置邮件正文
    	 message.setContent("<h1>来自送鸟的激活邮件,激活请点击一下链接:</h1><h3><a href = 'http://localhost:8080/regist_web/ActiveServlet?code = "+code+"'></a></h3>","text/html;charset=UTF-8");
    	 
    	 //发送一封激活邮件
    	 Transport.send(message);
    	 
     }
}
