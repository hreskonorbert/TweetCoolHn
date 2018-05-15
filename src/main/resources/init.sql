/*
    Database initialization script that runs on every web-application redeployment.
*/
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tweets;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
	CONSTRAINT name_not_empty CHECK (name <> ''),
	CONSTRAINT password_not_empty CHECK (password <> '')
);

CREATE TABLE tweets (
    id SERIAL PRIMARY KEY,
    poster TEXT ,
    content TEXT

);

INSERT INTO users (name, password) VALUES
	('norberthresko', 'pw'),
	('molnarmate', 'mm');


INSERT INTO tweets(poster,content) VALUES
  ('norberthresko','testTweet1forNorbi'),
  ('norberthresko','testTweet2forNorbi'),
  ('molnarmate','testTweet1forMate'),
  ('molnarmate','testTweet2forMate');




