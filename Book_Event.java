import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/Book_Event")


public class Book_Event extends HttpServlet{

public void init() {}

public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
Connection con;
try {
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_se","root","root123");
resp.setContentType("text/html");
PrintWriter out = resp.getWriter();

String Event_name = req.getParameter("Event_name");
String Event = req.getParameter("Event");
String Date = req.getParameter("Date");
String st = req.getParameter("st");
String et = req.getParameter("et");
String Venue = req.getParameter("Venue");
String Cateres = req.getParameter("Cateres");
String Username = req.getParameter("Username");




String query = "insert into event values("+"'"+Event_name+"',"+"'"+Event+"',"+"'"+Date+"',"+"'"+st+"',"+"'"+et+"',"+"'"+Venue+"',"+"'"+Cateres+"',"+"'"+Username+"'"+")";

Statement sta = con.createStatement();
sta.executeUpdate(query);
sta.close();
con.close();
out.println("Successfully Registered");
resp.sendRedirect("Home_index.html");
} catch (SQLException e) {
PrintWriter out1 = resp.getWriter();
out1.println(e);
}
}

public void destroy() {}
}

