create database contactdb;

use contactdb;

CREATE TABLE contact (
  contact_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  address varchar(45) NOT NULL,
  telephone varchar(45) NOT NULL,
  PRIMARY KEY (contact_id)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;


INSERT INTO contact (name,email,address,telephone) VALUES("Bill Gates","Bill.Gates@microsoft.com","CA","1800123456789"),
("Steve Jobs","Steve.Jobs@apple.com","CA","1800123456789"),
("Iqubal M Kaki","Iqubal.Kaki@szias.com","IND","00918390900733");

CREATE TABLE USERS (
  USER_ID int(11) NOT NULL AUTO_INCREMENT,
  USERNAME varchar(45) NOT NULL,
  PASSWORD varchar(45) NOT NULL,
  EMAIL varchar(45) NOT NULL,
  PRIMARY KEY (USER_ID)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

INSERT INTO USERS (USERNAME,email,PASSWORD) VALUES("Bill Gates","Bill.Gates@microsoft.com","CA"),
("Steve Jobs","Steve.Jobs@apple.com","CA"),
("Iqubal M Kaki","Iqubal.Kaki@szias.com","IND");