package com.codecool.wereneke;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MiniServlet extends HttpServlet {

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

        String future = "";
        JtwigTemplate template = JtwigTemplate.classpathTemplate("answer.html");
        JtwigModel model = JtwigModel.newModel();

        model.with("future", future);
        String answer = template.render(model);

        response.getWriter().write(answer);
    }

}
