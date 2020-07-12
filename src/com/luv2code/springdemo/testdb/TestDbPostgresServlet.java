package com.luv2code.springdemo.testdb;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDbServlet")
public class TestDbPostgresServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response){

        //setup connection variables
        String user = "springstudent";
        String pass = "springstudent";
        String jdbcUrl = "jdbc:postgres://localhost:5433/web_customer_tracker";
//        String user = "hbstudent";
//        String pass = "7-N6&fRWl0gw";

        String driver = "org.postgresql.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to db: " + jdbcUrl);

            Class.forName(driver);

            Connection myCon = DriverManager.getConnection(jdbcUrl,user, pass);

            out.println("Connection successful!!!");

            myCon.close();

        } catch (Exception e){
            // e.printStackTrace();
        }

    }
}
