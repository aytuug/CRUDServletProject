package service;

import Dao.EmpDao;
import Model.Emp;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ClientInfoStatus;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employeeServlet")
public class JsonServlet extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        List<Emp>  list = EmpDao.getAllEmployees();

            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print(gson.toJson(list));
            out.flush();



    }
}
