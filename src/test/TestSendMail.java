package test;

import org.junit.Test;

import util.SendMail;

public class TestSendMail {

	@Test
	public void testSendMail() {		
		String SMTPHost = "smtp.163.com";
		String Port= "25";
		String MailUsername = "mopixian@163.com";
		String MailPassword = "mo201406027";
		String MailFrom = "mopixian@163.com";
		if(SMTPHost==null||SMTPHost==""||MailUsername==null||MailUsername==""||MailPassword==null||MailPassword==""||MailFrom==null||MailFrom=="")
		{
			System.out.println("Servlet parameter Wrongs");
		}
		SendMail send = new SendMail(SMTPHost, Port, MailUsername, MailPassword);
		
		String MailTo= "994939734@qq.com";
		String MailSubject="Westlake International - Application Received";
		String MailBCopyTo="";
	    String MailCopyTo="";
	    
	    String MailBody="<p><img alt=\"westlakelogo\" src=\"http://www.expertsonchina.com/images/top.gif\" border=\"0\" /></p>"
	    +"<p>J2EE 邮件测试， 亲爱的 "+ "xxx" +",<br />" +
	    		"<br />" +
	    		"	欢迎您，您已经注册成功。</p>" +
	    		"	<p>We'd like to thank you for your interest in our expert   network business. We appreciate you taking time to apply for membership in our   expert community.</p>" +
	    		"	<p>To ensure the integrity and quality of our network, we seek to verify the   credentials of our experts. We hope that you understand it. We will send you a   confirmation email shortly.</p>" +
	    		"	<p>Best regards,<br />" +
	    		"	  <br />	Westlake International Team </p>	<p> </p>";
	    
	    send.sendingMimeMail(MailFrom, MailTo, MailCopyTo, MailBCopyTo, MailSubject, MailBody);
	}

	@Test
	public void testSendingMimeMail() {
		
	}

}
