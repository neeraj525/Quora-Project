/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import Modelpack.LoginDao;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;

/**
 *
 * @author home
 */
public class logServlet extends HttpServlet {
    private Object psw;
    private Object response;
    private Object res;
    private Object name;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {
        res.setContentType("text/html");  
    PrintWriter out = res.getWriter();  
          
    String n=req.getParameter("email");  
    String p=req.getParameter("pass");  
          System.out.print(n+" "+p);
          
    if(LoginDao.validate(n, p)){
        
        HttpSession session=req.getSession();  
        session.setAttribute("name",name);
        
        RequestDispatcher rd=req.getRequestDispatcher("QAengine.html");  
        rd.forward(req,res);  
    }  
    else{  
        out.print("<div class=\"w3-container w3-display-container w3-round w3-theme-l4 w3-border w3-theme-border w3-margin-bottom w3-hide-small\">");
        out.print("<span onclick=\"this.parentElement.style.display='none'\" class=\"w3-button w3-theme-l3 w3-display-topright\">");
        out.print(" <i class=\"fa fa-remove\"></i>");
        out.print("</span>");
        out.print("<p><strong>Hey!</strong></p>");
        out.print("<p>Wrong Email or Password</p>");
        out.print("</div>");
        RequestDispatcher rd=req.getRequestDispatcher("login.html");  
        rd.include(req,res);  
    }  
          
    out.close();  
    }  
       
    }
    

