import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test03 {
  public static void main(String args[]){
	  try{
	  Properties props = new Properties();  
      props.put("username", "13732283597");   
      props.put("password", "ming123456");   
      props.put("mail.transport.protocol", "smtp" );  
      props.put("mail.smtp.host", "smtp.139.com");  
      props.put("mail.smtp.port", "25" );  

      Session mailSession = Session.getDefaultInstance(props);  
      
      Message msg = new MimeMessage(mailSession);     
      msg.setFrom(new InternetAddress("13732283597@139.com"));  
  /*    msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse("wangjiafan1227@163.com"));   */
      msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse("wangjiafan1227@163.com"));   
      msg.setSubject("激活邮件");   
      msg.setContent("<h1>此邮件为官方激活邮件！请点击下面链接完成激活操作！</h1><h3><a href='http://localhost:8080/SendMail/servlet/ActiveServlet?code="+1233444+"'>http://localhost:8080/SendMail/servlet/ActiveServlet</a></h3>","text/html;charset=UTF-8");
      msg.saveChanges();  
      
      Transport transport = mailSession.getTransport("smtp");  
      transport.connect(props.getProperty("mail.smtp.host"), props  
              .getProperty("username"), props.getProperty("password"));   
      transport.sendMessage(msg, msg.getAllRecipients());  
      transport.close();     
  } catch (Exception e) {  
      e.printStackTrace();  
      
      
  }  
	  
	  
  }
}
