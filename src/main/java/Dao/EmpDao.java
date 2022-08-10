package Dao;

import ConnectionPostgreSQL.PostgreSQLConnection;
import Model.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection( "jdbc:postgresql://localhost:5432/appuserdb","postgres","aytug");
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public static int save(Emp emp) {
        int status = 0;
        try {
            Connection connection = EmpDao.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user905" +
                    "  (id, name, password, email, country) VALUES " +
                    " (DEFAULT,?, ?, ?, ?);");
            System.out.println(ps);
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getPassword());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getCountry());
            status = ps.executeUpdate();
            System.out.println(status);
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public static int update(Emp emp) {
        int status = 0;

        try {
            Connection connection = EmpDao.getConnection();
            PreparedStatement ps = connection.prepareStatement("update user905 set name=?,password=?,email=?,country=? where id=?");
            ps.setString(1, emp.getName());
            ps.setString(2,emp.getPassword());
            ps.setString(3,emp.getEmail());
            ps.setString(4,emp.getCountry());
            ps.setInt(5, emp.getId());

            status = ps.executeUpdate();

            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        /*
        try {
            Connection connection = EmpDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from user905 where id=?");
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

         */

        String sql = "DELETE FROM USER905 WHERE id = ?";
        int effectedRows = 0;
        try (Connection conn  = EmpDao.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            effectedRows = preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }


        return effectedRows;
    }

    public static Emp getEmployeeById(int id) {
        Emp  emp = new Emp();

        try {
            Connection connection = EmpDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user905 where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                emp.setId(resultSet.getInt(1));
                emp.setName(resultSet.getString(2));
                emp.setPassword(resultSet.getString(3));
                emp.setEmail(resultSet.getString(4));
                emp.setCountry(resultSet.getString(5));
            }

            connection.close();



        }catch (Exception e){
            e.printStackTrace();
        }

        return emp;
    }

    public static List<Emp> getAllEmployees() {

        List<Emp> list = new ArrayList<Emp>();
        try {
            Connection connection = EmpDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user905");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Emp e=new Emp();
                e.setId(resultSet.getInt(1));
                e.setName(resultSet.getString(2));
                e.setPassword(resultSet.getString(3));
                e.setEmail(resultSet.getString(4));
                e.setCountry(resultSet.getString(5));
                list.add(e);
            }
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }


}
