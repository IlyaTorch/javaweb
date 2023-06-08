-- mysql --user="sammy" --password="password" < db-create.sql
DROP DATABASE IF EXISTS courses;

CREATE DATABASE IF NOT EXISTS courses DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE courses;

CREATE TABLE IF NOT EXISTS USERS(
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR(30) NOT NULL UNIQUE,
  first_name VARCHAR (40) NOT NULL,
  last_name VARCHAR (40) NOT NULL,
  avg_mark FLOAT
) DEFAULT CHARSET utf8;


INSERT INTO USERS VALUES
  (DEFAULT, 'ilya@me.com', 'ilya', 'torch', 9.9),
  (DEFAULT, 'dasha@me.com', 'dasha', 'miss', 9.9),
  (DEFAULT, 'nikita@me.com', 'nick', 'torch', 9.9),
  (DEFAULT, 'james@me.com', 'james', 'bond', 4.9);
