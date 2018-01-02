package java_email;

import java.security.GeneralSecurityException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.*;

public class SendEmailWithQQEmail {
	public static void main(String[] args) {
		// 收件人电子邮箱
		String to = "qin-fei@foxmail.com";

		// 发件人电子邮箱
		// String from = "1750376793@qq.com";
		// String from = "qinguangrui123@163.com";
		String from = "loveyou_12@zoho.com.cn";

		// 指定发送邮件的主机为 localhost
		// String host = "smtp.qq.com";
		String host = "smtp.zoho.com.cn";

		// 获取系统属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");

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
				return new PasswordAuthentication(from, "xxxx");
			}
		});

		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// Set From: 头部头字段
			message.setFrom(new InternetAddress(from));

			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: 头部头字段
			message.setSubject("新年快乐");

			// 设置消息体

			String text = "截至到年月日，您的快乐预存款可用余额不足。祝福合计：健康平安发财幸福。请您尽快带本人微笑随时随地补充快乐，谢谢。元旦愉快。";

			message.setText(text);

			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
