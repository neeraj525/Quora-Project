package controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;

public class MyServlet2 implements Servlet {

    ServletConfig config = null;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        
        this.config=config;
        System.out.println("init method called");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            
        res.setContentType("text/html");
        
        PrintWriter out = res.getWriter();
        
        out.println("Hello World!");
        
        System.out.println("service method called");
    }

    @Override
    public String getServletInfo() {
        return "my servlet";
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method called");
    }
    
}
