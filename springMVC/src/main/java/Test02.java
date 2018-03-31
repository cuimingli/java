import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test02 {
  public static void main(String args[]) throws MessagingException{
	  Properties p = new Properties();
	  //开启debug
   	  p.setProperty("mail.debug", "true");
	  //发送服务器需要身份验证
      p.setProperty("mail.smtp.auth", "ture");
      //设置邮件服务器的主机名
   	  p.setProperty("mail.host", "smtp.139.com");
     //发送邮件的协议名称
   	  p.setProperty("mail.transport.protocol", "smtp");
   	 //设置环境信息
     Session session = Session.getInstance(p);
     
     Message msg = new MimeMessage(session);
     // 1邮件内容:主题、内容
     msg.setSubject("崔明利" + ",欢迎注册***账号,请点击链接激活账号");
     //设置邮件内容
     msg.setText("你好啊!!!!!!!");
      //发件人
     msg.setFrom(new InternetAddress("13732283597@139.com"));
     
     Transport transport = session.getTransport();
     //链接邮箱服务器
     transport.connect("13732283597", "ming123456");
      //发送邮件
     transport.sendMessage(msg, new Address[]{new InternetAddress("1585159171@qq.com")});
     //关闭邮件
     transport.close();
     
  }
}
