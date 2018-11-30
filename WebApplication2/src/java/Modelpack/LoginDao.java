/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelpack;

/**
 *
 * @author home
 */
import java.sql.*; 

public class LoginDao {
   public static boolean validate(String name,String pwd){  
boolean status=false;
 String u = new String();
         String q=new String();
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/signup?useSSL=false","root","evolutionary121nc");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from signdata where email=? and password=?");  
ps.setString(1, name);
ps.setString(2, pwd);
System.out.print(u+" "+q);
ResultSet rs=ps.executeQuery();
status=rs.next();
}
        catch(Exception e){ System.out.println(e);} 
      return  status;  
  
}

    public boolean check(String n, String p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }
}
