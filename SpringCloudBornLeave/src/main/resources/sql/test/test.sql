CREATE TABLE  dept
    (
        deptno Integer,
        dname VARCHAR(255),
        db_source VARCHAR(255),
         PRIMARY KEY (deptno)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    
  CREATE TABLE  account
    (
        accountId  Integer,
        deptId Integer,
        amount VARCHAR(255),
         PRIMARY KEY (accountId),
         constraint `fk` foreign key (`deptId`) references `dept`(`deptno`)      
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	
CREATE TABLE USER
(
	userId VARCHAR(32) NOT NULL,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	level bigint(1),
	PRIMARY KEY (userId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



