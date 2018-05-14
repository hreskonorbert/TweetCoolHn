package com.codecool.web.dao.database;

import com.codecool.web.dao.TweetDao;
import com.codecool.web.model.Tweet;
import com.codecool.web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTweetDao extends AbstractDao implements TweetDao {

    public DatabaseTweetDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Tweet> getAllTweets() throws SQLException {
        String sql = "SELECT * FROM tweets";
        List<Tweet> tweets = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                tweets.add(fetchTweet(resultSet));
            }
            return tweets;
        }
    }

    public Tweet fetchTweet(ResultSet resultSet) throws SQLException {
        String poster = resultSet.getString("poster");
        String content = resultSet.getString("content");
        return new Tweet(content,poster);
    }

    @Override
    public List<Tweet> getAllTweetsByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM tweets WHERE poster = ?";
        List<Tweet> tweets = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                tweets.add(fetchTweet(resultSet));
            }
            return tweets;
        }
    }

    @Override
    public void postTweet(String poster, String content) throws SQLException {
        String sql = "INSERT INTO tweets (poster,content) " +
            "VALUES(?,?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            connection.setAutoCommit(false);
            statement.setString(1,poster);
            statement.setString(2,content);
            executeInsert(statement);
            connection.commit();
        }
    }
}
