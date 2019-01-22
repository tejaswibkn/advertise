CREATE TABLE advertiser (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  advertiserName varchar(100) NOT NULL,
  advertiserContactName varchar(100) NOT NULL, 
  advertiserCreditLimit bigint(20) NOT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
