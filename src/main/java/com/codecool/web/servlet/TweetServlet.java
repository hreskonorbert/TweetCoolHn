package com.codecool.web.servlet;

import com.codecool.web.dao.TweetDao;
import com.codecool.web.dao.UserDao;
import com.codecool.web.dao.database.DatabaseTweetDao;
import com.codecool.web.dao.database.DatabaseUserDao;
import com.codecool.web.model.Tweet;
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

@WebServlet("/new-tweet")
public class TweetServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try (Connection connection = getConnection(req.getServletContext())) {

            TweetDao tDao = new DatabaseTweetDao(connection);


            String poster = req.getParameter("poster");
            String content = req.getParameter("content");
            tDao.postTweet(poster,content);


            req.getRequestDispatcher("homepage.jsp").forward(req,resp);


        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TweetDao tDao = new DatabaseTweetDao(connection);
            List<Tweet> tweets = tDao.getAllTweets();
            req.getSession().setAttribute("tweets",tweets);
            req.getRequestDispatcher("tweets.jsp").forward(req,resp);
        }catch (SQLException ex){
            handleSqlError(resp,ex);
        }
    }

}
