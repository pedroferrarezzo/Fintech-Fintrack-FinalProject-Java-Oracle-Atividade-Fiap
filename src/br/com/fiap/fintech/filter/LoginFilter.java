package br.com.fiap.fintech.filter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// /* = URL Coringa, qualquer URL será interceptada pelo filtro
@WebFilter("/*")
public class LoginFilter implements Filter {
    
    public LoginFilter() {
        super();

    }

	public void destroy() {

	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String url = req.getRequestURI();
		
		if (session.getAttribute("user") == null && !url.contains("login") &&!url.endsWith("/Fintech_Web_Project/") && !url.contains("error404") && !url.contains("resources") && !url.contains("home") && !url.contains("cadServlet") && !url.contains("index") && !url.contains("About")) {
			request.setAttribute("erro", "Entre com o usuário e senha!");
			request.getRequestDispatcher("/pages/login/home.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
