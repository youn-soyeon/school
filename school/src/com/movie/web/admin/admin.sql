CREATE TABLE Admin(
	id VARCHAR2(30) PRIMARY KEY,
	name VARCHAR2(30) NOT NULL,
	password VARCHAR2(30) NOT NULL,
	addr VARCHAR2(100),
	birth NUMBER,
	role VARCHAR2(30) DEFAULT 'admin'
);

SELECT * FROM Admin;

INSERT INTO Admin(id, name, password, addr, birth, role)
VALUES ('admin', '관리자', '1', '서울', 800808, 'admin');