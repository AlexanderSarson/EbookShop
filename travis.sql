CREATE USER 'dev'@'localhost' IDENTIFIED BY 'dev';
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON *.* TO 'dev'@'localhost';
DROP DATABASE IF EXISTS ebookshop;
CREATE DATABASE IF NOT EXISTS ebookshop;
USE ebookshop;

CREATE TABLE ebooks(
    ebook_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    price INT NOT NULL,
    qty INT NOT NULL,
    PRIMARY KEY(ebook_id)
);

CREATE TABLE customers(
    cust_id INT NOT NULL,
    cust_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(50),
    PRIMARY KEY(cust_id)
);

CREATE TABLE orders(
    order_id INT NOT NULL AUTO_INCREMENT,
    cust_id INT NOT NULL,
    ebook_id INT NOT NULL,
    price INT NOT NULL,
    qty INT NOT NULL,
    date DATETIME DEFAULT NOW(), 
    PRIMARY KEY(order_id),
    FOREIGN KEY(cust_id)
        REFERENCES customers(cust_id),
    FOREIGN KEY(ebook_id)
        REFERENCES ebooks(ebook_id)
);

INSERT INTO ebooks (title,author,price,qty) VALUES ("Lord of the Rings","Tolkien",20,11);
INSERT INTO ebooks (title,author,price,qty) VALUES ("Harry Potter","J.K Rowling",15,40);
INSERT INTO ebooks (title,author,price,qty) VALUES ("The Da Vinci Code","Dan Brown",22,34);
INSERT INTO ebooks (title,author,price,qty) VALUES ("The Pillars of the Earth","Ken Follett",30,12);