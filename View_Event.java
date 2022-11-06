
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(urlPatterns="/View_Event")

public class View_Event extends HttpServlet{

    public void init(){} 

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException { 
        String Username=req.getParameter("Username");
        
        
        Connection con; 
        try { 
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project_se","root","root123"); 
            Statement st=con.createStatement(); 
            int f=0; 
            PrintWriter out = res.getWriter();
            String q="SELECT * FROM event where Username='"+Username+"';"; 
            ResultSet rs=st.executeQuery(q); 
             
            out.print("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("table, th, td{");
            out.println("border-collapse: collapse;");
            out.println("border:1px solid;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr> ");
            out.println("<th>Event Name</th> ");
            
            out.println("<th>Event Type</th> ");
            out.println("<th>Event Date</th> ");
            out.println( "<th>Starting Time</th> ");
            out.println( "<th>Ending Time</th> ");
            out.println( "<th>Venue</th></th>");
            out.println( "<th>Cateres</th></th>");
            out.println("<th>User Name </th> ");
            out.println( "</thead>");
            while(rs.next()){
            out.println("<tbody><tr>");
            out.println("<td>"+rs.getString(1)+"</td>");
            out.println("<td>"+rs.getString(2)+"</td>");
            out.println("<td>"+rs.getString(3)+"</td>");
            out.println("<td>"+rs.getString(4)+"</td>");
            out.println("<td>"+rs.getString(5)+"</td>");
            out.println("<td>"+rs.getString(6)+"</td>");
            out.println("<td>"+rs.getString(7)+"</td>");
            out.println("<td>"+rs.getString(8)+"</td>");
            out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("</head>");
            out.println("</html>");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    public void destroy() { }

}