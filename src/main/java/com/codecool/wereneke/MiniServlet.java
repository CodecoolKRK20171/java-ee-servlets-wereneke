package com.codecool.wereneke;

import java.io.IOException;
import java.sql.SQLException;

import com.codecool.wereneke.dao.Dao;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MiniServlet extends HttpServlet {

    Dao dao = new Dao();

    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        JtwigTemplate template = JtwigTemplate.classpathTemplate("hello.html");
        JtwigModel model = JtwigModel.newModel();
        String answer = template.render(model);
        response.getWriter().write(answer);
    }

    protected void doPost( HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String color = request.getParameter("color");
        String date = request.getParameter("birthdate");

        String future = null;
        try {
            future = future(name, color, date);
            JtwigTemplate template = JtwigTemplate.classpathTemplate("answer.html");
            JtwigModel model = JtwigModel.newModel();

            model.with("future", future);
            String answer = template.render(model);

            response.getWriter().write(answer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String future(String name, String color, String birthdate) throws SQLException{

        String result = name + color + birthdate;
        int futureIndex = result.length() % 8;

        return dao.getFuture(futureIndex);
    }

}
