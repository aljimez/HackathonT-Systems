create database if not exists backend_challenge;
use backend_challenge;

CREATE TABLE IF NOT EXISTS susers(
id INT NOT NULL AUTO_INCREMENT,
username varchar(100) NOT NULL UNIQUE,
password varchar (255) NOT NULL,
role NVARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO susers (username,password, role) value ("admin",'$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', "admin");
INSERT INTO susers (username,password, role) value ("marraya",'$2a$10$6pBWgEtPi/kMtZ7l4ik6SudQGHyf1.oi0q/5VvKzpgZ32yZ88Iw9q', "editor");
INSERT INTO susers (username,password, role) value ("AntAn",'$2a$10$xwVYF5bGk7V2b.HSmy/haOdN9QGQvjLIWeYrJqDR5v8E9urCD4zUW', "editor");
INSERT INTO susers (username,password, role) value ("NicoGico",'$2a$10$s.8JK58WTHv6tsHb6/FV/e5VZ1ZcAdmhxIvukAOdEYHMWHSKsFLJS', "user");
