CREATE USER 'dev'@'localhost' IDENTIFIED BY 'dev';
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON *.* TO 'dev'@'localhost';
CREATE DATABASE IF NOT EXISTS qoutesdb;
USE qoutesdb;
CREATE TABLE qoutes(
    qoutes VARCHAR(100) NOT NULL
);

INSERT INTO qoutes (qoutes) VALUES ("blabla"),("klakla"),("okok"),("yes mand!"),("SUPER GODT"),("MEGET VIGTIGT");