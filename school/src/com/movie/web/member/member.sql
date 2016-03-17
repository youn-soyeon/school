SELECT * FROM Test;

CREATE TABLE Member(
	id VARCHAR2(30) PRIMARY KEY,
	name VARCHAR2(30) NOT NULL,
	password VARCHAR2(30) NOT NULL,
	addr VARCHAR2(100),
	birth NUMBER
);

INSERT INTO Member(id, name, password, addr, birth)
VALUES ('hong', '홍길동', '1', '서울', 800101);
INSERT INTO Member(id, name, password, addr, birth)
VALUES ('kim', '김유신', '1', '경기', 900203);
INSERT INTO Member(id, name, password, addr, birth)
VALUES ('lee', '이순신', '1', '부산', 000909);
INSERT INTO Member(id, name, password, addr, birth)
VALUES ('song', '송중기', '1', '대전', 041001);
INSERT INTO Member
VALUES ('yoon', '윤동주', '1', '인천', 060201);

SELECT * FROM Member;

SELECT * FROM Member
WHERE id = 'kim';

