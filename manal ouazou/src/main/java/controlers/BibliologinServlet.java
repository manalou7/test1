package controlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;

public class BibliologinServlet extends HttpServlet  {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  

	        response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	        
	        String n=request.getParameter("bibliologin");  
	        String p=request.getParameter("bibliopassword"); 
	        
	        HttpSession session = request.getSession(false);
	        if(session!=null)
	        session.setAttribute("name", n);

	        if(LoginDao.validate(n, p)){  
	            RequestDispatcher rd=request.getRequestDispatcher("biblio_welc.jsp");  
	            rd.forward(request,response);  
	        }  
	        else{  
	            out.print("<p style=\"color:red\">Sorry username or password error</p>");  
	            RequestDispatcher rd=request.getRequestDispatcher("New.jsp");  
	            rd.include(request,response);  
	        }  

	        out.close();  
	    }  

}
