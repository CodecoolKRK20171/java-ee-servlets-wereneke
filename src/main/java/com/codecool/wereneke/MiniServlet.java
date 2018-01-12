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

        String answer = getFileWithUtil("hello.html");
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

    private String getFileWithUtil(String fileName) {

        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
