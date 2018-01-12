package com.codecool.wereneke;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MiniServlet extends HttpServlet {

    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().write("<html><body>GET response</body></html>");
    }

    protected void doPost( HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().write("<html><body>POST response</body></html>");

    }
}
