package com.codecool.web.servlet;

import com.codecool.web.dao.TweetDao;
import com.codecool.web.dao.UserDao;
import com.codecool.web.dao.database.DatabaseTweetDao;
import com.codecool.web.dao.database.DatabaseUserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleLoginService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login")
public final class LoginServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try (Connection connection = getConnection(req.getServletContext())) {
            UserDao userDao = new DatabaseUserDao(connection);
            TweetDao tDao = new DatabaseTweetDao(connection);
            LoginService loginService = new SimpleLoginService(userDao);

            String name = req.getParameter("name");
            String password = req.getParameter("password");

            User user = loginService.loginUser(name, password);
            req.getSession().setAttribute("name", name);
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("homepage.jsp").forward(req,resp);


        } catch (ServiceException ex) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }
}
