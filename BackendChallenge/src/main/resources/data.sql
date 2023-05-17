create database if not exists safein_test;
use safein_test;

CREATE TABLE IF NOT EXISTS susers(
id INT NOT NULL AUTO_INCREMENT,
username varchar(100) NOT NULL UNIQUE,
password varchar (255) NOT NULL,
nomapels varchar(255) NOT NULL,
email varchar(255) NOT NULL,
role NVARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO susers (username,password,nomapels,email, role) value ("admin",'$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.',"admin","nomail@gmail.com", "admin");
INSERT INTO susers (username,password,nomapels,email, role) value ("marraya",'$2a$10$6pBWgEtPi/kMtZ7l4ik6SudQGHyf1.oi0q/5VvKzpgZ32yZ88Iw9q',"Maria Raices","mrraynet@gmail.com", "editor");
INSERT INTO susers (username,password,nomapels,email, role) value ("AntAn",'$2a$10$xwVYF5bGk7V2b.HSmy/haOdN9QGQvjLIWeYrJqDR5v8E9urCD4zUW',"Antonio Andres","antmannn@gmail.com", "editor");
INSERT INTO susers (username,password,nomapels,email, role) value ("NicoGico",'$2a$10$s.8JK58WTHv6tsHb6/FV/e5VZ1ZcAdmhxIvukAOdEYHMWHSKsFLJS',"Nicolas Gimenez","nicogi@gmail.com", "user");
