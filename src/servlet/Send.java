package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.SendMail;

/**
 * Servlet implementation class SendMail
 */
public class Send extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private ServletConfig config;
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
	}
	
    public Send() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = "";		
		String email = "";
		String msg = "";
		
		if(sendMail(email, username)){
			System.out.println("发送成功");
		}else{
			System.out.println("发送失败");
		}
	}
	
	private boolean sendMail(String mailto,String username){
		String MailTo=mailto;
		String MailSubject="Westlake International - Application Received";
		String MailBCopyTo="";
	    String MailCopyTo="";
	    
	    String MailBody="<p><img alt=\"westlakelogo\" src=\"http://www.expertsonchina.com/images/top.gif\" border=\"0\" /></p>"
	    +"<p>J2EE 邮件测试， 亲爱的 "+username+",<br />" +
	    		"<br />" +
	    		"	欢迎您，您已经注册成功。</p>" +
	    		"	<p>We'd like to thank you for your interest in our expert   network business. We appreciate you taking time to apply for membership in our   expert community.</p>" +
	    		"	<p>To ensure the integrity and quality of our network, we seek to verify the   credentials of our experts. We hope that you understand it. We will send you a   confirmation email shortly.</p>" +
	    		"	<p>Best regards,<br />" +
	    		"	  <br />	Westlake International Team </p>	<p> </p>";
		String SMTPHost = "smtp.163.com";
		String Port= "25";
		String MailUsername = "mopixian@163.com";
		String MailPassword = "mo130154517";
		String MailFrom = "mopixian@163.com";
		if(SMTPHost==null||SMTPHost==""||MailUsername==null||MailUsername==""||MailPassword==null||MailPassword==""||MailFrom==null||MailFrom=="")
		{
			System.out.println("Servlet parameter Wrongs");
		}
		SendMail send = new SendMail(SMTPHost, Port, MailUsername, MailPassword);
		if(send.sendingMimeMail(MailFrom, MailTo, MailCopyTo, MailBCopyTo, MailSubject, MailBody)){
			return true;
		}else{
			return false;
		}
	}
}
