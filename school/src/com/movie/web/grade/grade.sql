CREATE TABLE Grade(
	hak NUMBER PRIMARY KEY,
	id VARCHAR2(30) NOT NULL,
	java NUMBER NOT NULL,
	sql NUMBER NOT NULL,
	jsp NUMBER NOT NULL,
	spring NUMBER NOT NULL
);

SELECT * FROM Grade;

DROP TABLE Grade;

-- 시퀀스 생성
CREATE SEQUENCE hak
START WITH 160001
INCREMENT BY 1;

DROP SEQUENCE hak;

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'hong', 50, 60, 20, 30);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'kim', 90, 30, 70, 80);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'lee', 80, 75, 65, 100);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'song', 85, 85, 85, 85);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'yoon', 100, 85, 95, 90);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'kim2', 20, 10, 55, 45);

SELECT * FROM Grade
WHERE id = 'song';
