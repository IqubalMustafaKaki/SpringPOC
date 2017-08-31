create database contactdb;
use TUTORIALS;
CREATE TABLE contact (
  contact_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  address varchar(45) NOT NULL,
  telephone varchar(45) NOT NULL,
  PRIMARY KEY (contact_id)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

INSERT INTO contact (name,email,address,telephone)
                       VALUES
                       ("Steve Job", "Steve.Jobs@apple.com","CA","8390900733");
INSERT INTO contact (name,email,address,telephone)
                       VALUES
                       ("Bill Gates", "Bill.Gates@microsoft.com","CA","8390900733");
INSERT INTO contact (name,email,address,telephone)
                       VALUES
                       ("Iqubal M Kaki", "Iqubal.MKaki@szias.com","INDIA","8390900733");