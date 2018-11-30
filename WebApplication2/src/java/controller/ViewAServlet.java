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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author home
 */
public class ViewAServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewAServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewAServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
 Statement st=null; 
 String query=null;
 String query1=null;
 ResultSet rs1=null;
 Statement st1=null;
 
int c=Integer.parseInt(request.getParameter("q_id"));
int d=Integer.parseInt(request.getParameter("a_id"));
           
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/signup?useSSL=false","root","evolutionary121nc");  
           

PreparedStatement ps=con.prepareStatement("select * from awn where q_id=? and a_id=?");
PreparedStatement ps1=con.prepareStatement("select add_q from ques where q_id=?");


ResultSet rsa=ps.executeQuery();

ResultSet rsq=ps1.executeQuery();

String que = rsq.getString(1);

List<String> ans = new ArrayList<>();

while(rsa.next()){
    ans.add(rsa.getString(3));
}

request.setAttribute("que",que);

request.setAttribute("ans", ans);


//out.print("<html>");
//out.print("<title>view Questions</title>");
//out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
//out.print("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
//out.print("<body>"); 
//              





              
/* Printing result */  
//  
//while(rs.next())  
//{  
//out.print("<div class=\"w3-container\"> ");
//out.print("<h2>Awnsers</h2>");
//out.print("<h3>Q-id: "+rs.getInt(1)+"</h3>");
//out.print("<h4>A-id: "+rs.getInt(2)+"</h4>");
//
//
//
//while(rs1.next())
//{
//  rs1=ps1.executeQuery();
//out.print("<p>Q: "+rs1.getString(2)+"</p>");
//}
//out.print("<p>"+rs.getString(3)+"</p>");
//out.print("<a href=#>");
//out.print(" <button class=\"float-left submit-button\" >Q with A</button>");
//out.print("</a>");
//out.print("</form>");
//out.print("<hr>");
//
//out.print("</div>");
//}  
//  
//out.print("</body>");
//out.printf("</html>");

}catch(Exception e){
        System.out.print(e);
        }


RequestDispatcher rd = request.getRequestDispatcher("displayAnswer.jsp");
rd.forward(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   

}
