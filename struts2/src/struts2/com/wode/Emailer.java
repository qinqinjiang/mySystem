package struts2.com.wode;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

/**
 * struts2�����ʼ�����
 * @author ������
 *
 * 2018��2��8��
 */
public class Emailer extends ActionSupport{

	private String from;
	   private String password;
	   private String to;
	   private String subject;
	   private String content;

	   static Properties properties = new Properties();
	   static{
	      properties.put("mail.smtp.host", "smtp.qq.com");
	      properties.put("mail.smtp.socketFactory.port", "465");
	      properties.put("mail.smtp.socketFactory.class",
	                     "javax.net.ssl.SSLSocketFactory");
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.port", "465");
	   }

	   public String execute() 
	   {
	      String ret = SUCCESS;
	      try
	      {
	         Session session = Session.getDefaultInstance(properties,  
	            new javax.mail.Authenticator() {
	            protected PasswordAuthentication 
	            getPasswordAuthentication() {
	            return new 
	            PasswordAuthentication(from, password);
	            }});

	         Message message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.setRecipients(Message.RecipientType.TO, 
	            InternetAddress.parse(to));
	         message.setSubject(subject);
	         message.setText(content);
	         Transport.send(message);
	      }
	      catch(Exception e)
	      {
	         ret = ERROR;
	         e.printStackTrace();
	      }
	      return ret;
	   }

	   public String getFrom() {
	      return from;
	   }

	   public void setFrom(String from) {
	      this.from = from;
	   }

	   public String getPassword() {
	      return password;
	   }

	   public void setPassword(String password) {
	      this.password = password;
	   }

	   public String getTo() {
	      return to;
	   }

	   public void setTo(String to) {
	      this.to = to;
	   }

	   public String getSubject() {
	      return subject;
	   }

	   public void setSubject(String subject) {
	      this.subject = subject;
	   }

	   public String getContent() {
	      return content;
	   }

	   public void setContent(String content) {
	      this.content = content;
	   }

	   public static Properties getProperties() {
	      return properties;
	   }

	   public static void setProperties(Properties properties) {
	      Emailer.properties = properties;
	   }
}
