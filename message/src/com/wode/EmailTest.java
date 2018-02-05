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
 * ����ӿڲ��Է����ı�
 * @author hlrj
 *
 */
public class EmailTest {
	
	public static String myEmailAccount = "938660153@qq.com";//����������
	public static String myEmailPassword = "hsvrcejyaxkwbcgh"; //��Ȩ��
	public static String SmtpHost = "smtp.qq.com";  //������SMTP��������ַ
	public static String receiveMail = "938660153@qq.com";  //�ռ�������
	
	public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
		//������������
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");  //ʹ��Э��
		properties.setProperty("mail.smtp.host", SmtpHost);
		properties.setProperty("mail.smtp.auth", "true");
		// SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
        //                  ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
        //                  QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
        final String smtpPort = "465";
        properties.setProperty("mail.smtp.port", smtpPort);
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.port", smtpPort);
		Session session = Session.getInstance(properties);  //�����Ự����
		session.setDebug(true);  //����Ϊdebugģʽ�����Բ鿴��ϸ�ķ���log
		//�����ʼ�
		MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMail);
		//����session��ȡ�ʼ��������
		Transport transport = session.getTransport();
		//�����ʼ�������
		transport.connect(myEmailAccount, myEmailPassword);
		//�����ʼ���������message.getAllRecipients()
		transport.sendMessage(message, message.getAllRecipients());
		//�ر�����
		transport.close();
	}
	
	/**
	 * �����ʼ�
	 * @param session
	 * @param sendEmai
	 * @param receiveEmail
	 * @return
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 */
	public static MimeMessage createMimeMessage(Session session,String sendEmail,String receiveEmail) throws UnsupportedEncodingException, MessagingException{
		MimeMessage message = new MimeMessage(session);
		//�����ˣ������ǳ��й�����ɣ����ܻᱻ����
		message.setFrom(new InternetAddress(sendEmail, "����", "UTF-8"));
		//�ռ��ˣ����ж���ռ��ˡ����͡����ͣ�
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveEmail, "����", "UTF-8"));
		//���ñ���
		message.setSubject("qinqinjiang�Ĳ���","UTF-8");
		//�����ʼ�����
		message.setContent("�����ʼ��ӿ�", "text/html;charset=utf-8");
		//���÷���ʱ��
		message.setSentDate(new Date());
		//��������
		message.saveChanges();
		return message;
	}
}
