-- 시퀀스 생성
CREATE SEQUENCE score_seq
START WITH 1
INCREMENT BY 1;

CREATE TABLE Grade(
	score_seq NUMBER PRIMARY KEY,
	id VARCHAR2(30) NOT NULL,
	java NUMBER NOT NULL,
	sql NUMBER NOT NULL,
	jsp NUMBER NOT NULL,
	spring NUMBER NOT NULL
);

SELECT * FROM Grade;
DROP TABLE Grade CASCADE CONSTRAINT;
DROP SEQUENCE hak;

DROP SEQUENCE hak;

INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES (score_seq.NEXTVAL, 'hong', 50, 60, 20, 30);
INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES (score_seq.NEXTVAL, 'hong', 23, 12, 45, 78);
INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES (score_seq.NEXTVAL, 'kim', 90, 30, 70, 80);
INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES (score_seq.NEXTVAL, 'lee', 80, 75, 65, 100);
INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES (score_seq.NEXTVAL, 'song', 85, 85, 85, 85);
INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES (score_seq.NEXTVAL, 'yoon', 100, 85, 95, 90);
INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES (score_seq.NEXTVAL, 'kim2', 20, 10, 55, 45);
INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES (score_seq.NEXTVAL, 'kim2', 1, 1, 1, 1);

SELECT * FROM Grade;

SELECT * FROM Grade
WHERE id = 'song';
