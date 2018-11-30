/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author home
 */
public class SearchQ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchQ</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchQ at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String em=request.getParameter("email");  
           
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/signup?useSSL=false","root","evolutionary121nc");  
              
PreparedStatement ps=con.prepareStatement("select * from ques where email=?");  
ps.setString(1,em);  

ResultSet rs=ps.executeQuery();

out.print("<html>");
out.print("<title>view Questions</title>");
out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
out.print("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
out.print("<body>"); 
              

              
/* Printing result */  
  
while(rs.next())  
{  
out.print("<div class=\"w3-container\"> ");
out.print("<h2>"+rs.getString(1)+"</h2>");
out.print("<h3>Q-id: "+rs.getInt(3)+"</h3>");
out.print("<p>"+rs.getString(2)+"</p>");
out.print("<a href=Apage.html>");
out.print(" <button class=\"float-left submit-button\" >Awnser</button>");
out.print("</a>");
out.print("</form>");
out.print("<hr>");

out.print("</div>");
}  
  
out.print("</body>");
out.printf("</html>");

}catch(Exception e){
        System.out.print(e);
        }
out.close();        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

}
