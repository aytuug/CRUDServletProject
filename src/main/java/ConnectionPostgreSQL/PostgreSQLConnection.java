package ConnectionPostgreSQL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {

    private Connection connection ;
    private static String username = "postgres";
    private static String password = "aytug";
    private static PostgreSQLConnection jdbc;

    private PostgreSQLConnection(){

    }
    public static PostgreSQLConnection getInstance(){
        if (jdbc ==null){
            jdbc = new PostgreSQLConnection();
        }
        return jdbc;
    }
    public Connection openConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/appuserdb?autoReconnect=true",
                    username, password
            );
            System.out.println("Connection is successfull");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());

        }

        return connection;
    }

    public void closeConnection(){
        //TODO CONNECTION'U KAPAT!!

        try {
            // Obtaining a connection to SQL Server
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/testdb",
                    username, password
            );

            // Connection is ready to use
            DatabaseMetaData meta =  this.connection.getMetaData();
            System.out.println("Server name: "
                    + meta.getDatabaseProductName());
            System.out.println("Server version: "
                    + meta.getDatabaseProductVersion());

            // Closing the connection
            this.connection.close();
            if (this.connection.isClosed()){
                System.out.println("Connection closed");
            }

        }catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }



    }



    public Connection getConnection() {
        return connection;
    }





}
