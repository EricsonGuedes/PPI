package filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Usuario;

@WebFilter("/*")
public class LogFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	FileWriter logRequest;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario)session.getAttribute("logado");
		
		logRequest = new FileWriter(new File("C:\\Users\\erics/logreqPaisLogin.log"), true);
		logRequest.append("^^^^^^^^^^^^^^^^^^^^^^^^ \n");
		
		if(usuario == null){
	    	//System.out.println(req.getParameter("command"));
			logRequest.append("Situação do login: " + req.getParameter("command")  + "\n");
		} else {
			//System.out.println(usuario.getUsername()+ " -> " + req.getParameter("command"));
			logRequest.append("Situação do login: " + usuario.getUsername() + " ->" + req.getParameter("command") + "\n");
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
		if(usuario == null){
			//System.out.println(req.getParameter("command"));
			logRequest.append(req.getParameter("command")  + "\n");

		} else {
			//System.out.println(req.getParameter("command")+" -> " + usuario.getUsername());
			logRequest.append("Situação do login: " + usuario.getUsername() + " ->" + req.getParameter("command") + "\n");

		}
		logRequest.append("^^^^^^^^^^^^^^^^^^^^^^^^ \n");
		logRequest.flush();
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
