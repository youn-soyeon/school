CREATE TABLE Grade(
	hak NUMBER PRIMARY KEY,
	id VARCHAR2(30) NOT NULL,
	java NUMBER,
	sql NUMBER,
	jsp NUMBER,
	spring NUMBER
);

SELECT * FROM Grade;

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (160001, 'hong', 50, 60, 20, 30);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (150002, 'kim', 90, 30, 70, 80);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (130003, 'lee', 80, 75, 65, 100);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (120004, 'song', 85, 85, 85, 85);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (110005, 'yoon', 100, 85, 95, 90);
