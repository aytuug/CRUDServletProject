package service;

import ConnectionPostgreSQL.PostgreSQLConnection;
import Dao.EmpDao;
import Model.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        Emp emp = new Emp();
        emp.setName(name);
        emp.setPassword(password);
        emp.setEmail(email);
        emp.setCountry(country);

        int status = EmpDao.save(emp);
        try {
            if (status > 0){
                out.print("<p> Record saved successfully!</p>");
                req.getRequestDispatcher("index.html").include(req, resp);
            }else {
                out.print("UNABLE TO SAVE RECORD");
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        out.close();

    }
}
