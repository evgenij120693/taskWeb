package controller;

import sqlmanager.HandlerSQL;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Шмыга on 22.02.2017.
 */
public class ListStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            resp.sendRedirect("/error");
        }
        HandlerSQL handlerSQL = new HandlerSQL();
        try {
            ArrayList<Student> list = handlerSQL.selectFromTable(Student.class,0,"");
            req.setAttribute("listStudents", list);
            getServletContext().getRequestDispatcher("/listStudents.jsp").forward(req, resp);
        } catch (SQLException e) {
            resp.sendRedirect("/error");
        } catch (IllegalAccessException e) {
            resp.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
    }
}
