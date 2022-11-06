import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/login_index")

public class Sign_Up extends HttpServlet{

public void init() {}

public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
Connection con;
try {
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_se","root","root123");
resp.setContentType("text/html");
PrintWriter out = resp.getWriter();

String Username = req.getParameter("Username");
String Password = req.getParameter("Password");
String Email = req.getParameter("Email");


String Phoneno = req.getParameter("Phoneno");


String query = "insert into customers values("+"'"+Username+"',"+"'"+Password+"',"+"'"+Email+"',"+"'"+Phoneno+"'"+")";

Statement st = con.createStatement();
st.executeUpdate(query);
st.close();
con.close();
out.println("Successfully Registered");
resp.sendRedirect("login_index.html");
} catch (SQLException e) {
PrintWriter out1 = resp.getWriter();
out1.println(e);
}
}

public void destroy() {}
}
