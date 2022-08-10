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

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid)  ;

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        Emp emp = new Emp();
        emp.setId(id);
        emp.setName(name);
        emp.setPassword(password);
        emp.setEmail(email);
        emp.setCountry(country);

        int status = EmpDao.update(emp);
        if (status > 0){
            resp.sendRedirect("ViewServlet");
        }else {
            out.println("Sorry! unable to update record");
        }

        out.close();

    }
}
