-- Create the database named 'mybatis'.  
-- It's OK to use `, not OK to use ' or " surrounding the database name to prevent it from being interpreted as a keyword if possible.  
CREATE DATABASE IF NOT EXISTS `mybatis`  
DEFAULT CHARACTER SET = `UTF8`;  

-- Drop the table if exists
DROP TABLE IF EXISTS `user`;

-- Create a table named 'User'  
CREATE TABLE `user` (  
    `id` int(11) NOT NULL AUTO_INCREMENT,  
    `name` varchar(50) DEFAULT NULL,  
    `age` int(11) DEFAULT NULL,  
    `address` varchar(200) DEFAULT NULL,  
    PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;  
  
-- Insert a test record  
Insert INTO `user` VALUES ('1', 'Sam', '20', 'shanghai');

-- Drop the table if exists  
DROP TABLE IF EXISTS `Article`;  
      
-- Create a table named 'Article'  
CREATE TABLE `Article` (  
    `id` int NOT NULL AUTO_INCREMENT,  
    `user_id` int NOT NULL,  
    `title` varchar(100) NOT NULL,  
    `content` text NOT NULL,  
    PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;  
      
-- Add several test records  
INSERT INTO `article`  
VALUES  
('1', '1', 'title1', 'content1'),  
('2', '1', 'title2', 'content2'),  
('3', '1', 'title3', 'content3'),  
('4', '1', 'title4', 'content4');  