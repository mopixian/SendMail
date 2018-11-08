package servlet;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Code;

/**
 * Servlet implementation class Code
 */

public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getCode(request, response);
	}
	
	public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException{		
		Code c = Code.getInstance();	
		c.getImage();	
		String code = c.getCode();		
		request.getSession().setAttribute("code",code);;
		System.out.println(code);
		ImageIO.write(c.getImage(), "jpg", response.getOutputStream());
		System.out.println(c.getImage());
	}

}
