
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(urlPatterns="/index")

public class login extends HttpServlet{

    public void init(){} 

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException { 
        String Username=req.getParameter("Username"); 
        String Password=req.getParameter("Password"); 
        Connection con; 
        try { 
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project_se","root","root123"); 
            Statement st=con.createStatement(); 
            int f=0; 
            String q="SELECT * FROM customers;"; 
            ResultSet rs=st.executeQuery(q); 
            while(rs.next()){ 
                if(rs.getString(1).equals(Username) && rs.getString(2).equals(Password)) { 
                    f=1; 
                    break; 
                } 
            } 
            if(f==1) {
                res.sendRedirect("Home_index.html");

                } 
            else if(f==0) { 
                res.sendRedirect("login_index.html");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    public void destroy() { }

}