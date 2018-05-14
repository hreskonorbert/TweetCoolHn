package com.codecool.web.dao;

import com.codecool.web.model.Tweet;

import java.sql.SQLException;
import java.util.List;

public interface TweetDao {

    List<Tweet> getAllTweets() throws SQLException;

    List<Tweet> getAllTweetsByUsername(String username)throws SQLException;

    void postTweet(String poster, String content)throws SQLException;



}
