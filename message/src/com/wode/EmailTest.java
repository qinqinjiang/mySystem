package com.wode;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * 邮箱接口测试发送文本
 * @author hlrj
 *
 */
public class EmailTest {
	
	public static String myEmailAccount = "938660153@qq.com";//发件人邮箱
	public static String myEmailPassword = "hsvrcejyaxkwbcgh"; //授权码
	public static String SmtpHost = "smtp.qq.com";  //发件人SMTP服务器地址
	public static String receiveMail = "938660153@qq.com";  //收件人邮箱
	
	public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
		//创建参数配置
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");  //使用协议
		properties.setProperty("mail.smtp.host", SmtpHost);
		properties.setProperty("mail.smtp.auth", "true");
		// SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "465";
        properties.setProperty("mail.smtp.port", smtpPort);
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.port", smtpPort);
		Session session = Session.getInstance(properties);  //创建会话对象
		session.setDebug(true);  //设置为debug模式，可以查看详细的发送log
		//创建邮件
		MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMail);
		//根据session获取邮件传输对象
		Transport transport = session.getTransport();
		//连接邮件服务器
		transport.connect(myEmailAccount, myEmailPassword);
		//发送邮件，接收者message.getAllRecipients()
		transport.sendMessage(message, message.getAllRecipients());
		//关闭连接
		transport.close();
	}
	
	/**
	 * 创建邮件
	 * @param session
	 * @param sendEmai
	 * @param receiveEmail
	 * @return
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 */
	public static MimeMessage createMimeMessage(Session session,String sendEmail,String receiveEmail) throws UnsupportedEncodingException, MessagingException{
		MimeMessage message = new MimeMessage(session);
		//发件人，若是昵称有广告嫌疑，可能会被屏蔽
		message.setFrom(new InternetAddress(sendEmail, "亲亲", "UTF-8"));
		//收件人（可有多个收件人、抄送、密送）
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveEmail, "芹芹", "UTF-8"));
		//设置标题
		message.setSubject("qinqinjiang的测试","UTF-8");
		//设置邮件内容
		message.setContent("测试邮件接口", "text/html;charset=utf-8");
		//设置发送时间
		message.setSentDate(new Date());
		//保存设置
		message.saveChanges();
		return message;
	}
}
