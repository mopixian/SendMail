package util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import bean.Auth;

public class SendMail {
	
	private Properties properties;
	private Session session;
	private MimeMessage message;
	
	public SendMail(String SMTPHost,String Port, String MailUsername, String MailPassword){
		
		Auth auth = new Auth(MailUsername, MailPassword);
		
		properties = System.getProperties();
		properties.put("mail.smtp.host", SMTPHost);
		properties.put("mail.smtp.port", Port);
		properties.put("mail.smtp.auth", "true");
		
		session = Session.getInstance(properties, auth);
	}
	
	public boolean sendingMimeMail(String MailFrom, String MailTo,String MailCopyTo, String MailBCopyTo, String MailSubject, String MailBody){
		try {
			message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(MailFrom));
			if(MailTo != null){
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MailTo));
			}
			
			if(MailBCopyTo != null){
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(MailCopyTo));
			}
			
			if(MailBCopyTo != null){
				message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(MailBCopyTo));
			}
			
			message.setSubject(MailSubject,"gb2312");
			
			message.setContent(MailBody,"text/html;charset=gb2312");
			
			Transport.send(message);
			return true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}	
	}
	
}
