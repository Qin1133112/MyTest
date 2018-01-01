package java_email;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.*;
 
public class SendFileEmail
{
   public static void main(String [] args)
   {
     
	   // 收件人电子邮箱
	   String to = "qin-fei@foxmail.com";
 
      // 发件人电子邮箱
	   String from = "loveyou_12@zoho.com.cn";
 
      // 指定发送邮件的主机为 localhost
	   String host = "smtp.zoho.com.cn";
 
      // 获取系统属性
      Properties properties = System.getProperties();
      
 
      // 设置邮件服务器
      properties.setProperty("mail.smtp.host", host);
      properties.put("mail.smtp.auth", "true");
 
//      // 获取默认的 Session 对象。
//      Session session = Session.getDefaultInstance(properties);
      
      
   // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
   		MailSSLSocketFactory sf;
   		try {
   			sf = new MailSSLSocketFactory();
   			sf.setTrustAllHosts(true);
   			properties.put("mail.smtp.ssl.enable", "true");
   			properties.put("mail.smtp.ssl.socketFactory", sf);
   		} catch (GeneralSecurityException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}

   		// 获取默认session对象
   		Session session = Session.getDefaultInstance(properties, new Authenticator() {
   			@Override
   			protected PasswordAuthentication getPasswordAuthentication() {
   				// TODO Auto-generated method stub
//   				return new PasswordAuthentication("1750376793@qq.com", "fnuimxpuxuvgdcbd");
   				return new PasswordAuthentication(from, "1133112qgr");
   			}
   		});

 
      try{
         // 创建默认的 MimeMessage 对象。
         MimeMessage message = new MimeMessage(session);
 
         // Set From: 头部头字段
         message.setFrom(new InternetAddress(from));
 
         // Set To: 头部头字段
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
 
         // Set Subject: 头字段
         message.setSubject("This is the Subject Line!");
 
         // 创建消息部分
         BodyPart messageBodyPart = new MimeBodyPart();
 
         // 消息
         messageBodyPart.setText("This is message body");
        
         // 创建多重消息
         Multipart multipart = new MimeMultipart();
 
         // 设置文本消息部分
         multipart.addBodyPart(messageBodyPart);
         
 
         // 附件部分
         messageBodyPart = new MimeBodyPart();
         
         
         String filepath = "src/java_email/file.txt";
         
         File file = new File(filepath);
         
         DataSource source = new FileDataSource(file);

         messageBodyPart.setDataHandler(new DataHandler(source));
         
         String fileName = "activation.jar.txt";
         messageBodyPart.setFileName(fileName);
         multipart.addBodyPart(messageBodyPart);
         
         System.out.println("multipart:"+multipart.getContentType());
 
         // 发送完整消息
         message.setContent(multipart);
//         message.setText("abc");
 
         //   发送消息
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}
