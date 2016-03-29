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
VALUES ('lee', '이순신', '1', '부산', 100909);
INSERT INTO Member(id, name, password, addr, birth)
VALUES ('song', '송중기', '1', '대전', 141001);
INSERT INTO Member
VALUES ('yoon', '윤동주', '1', '인천', 160201);
INSERT INTO Member(id, name, password, addr, birth)
VALUES ('kim2', '김유신', '1', 'LA', 851111);
INSERT INTO Member(id, name, password, addr, birth)
VALUES ('yu', '유아인', '1', '강릉', 920505);


SELECT * FROM Member;

SELECT * FROM Member
WHERE id = 'kim';

DROP TABLE Member CASCADE CONSTRAINT;

SELECT * FROM Member
WHERE id = 'kim' and password = '1';

DELETE FROM Member
WHERE id = '3';

UPDATE Member SET major = 'computer', subject = 'java/sql/jsp/spring' WHERE id='hong';
UPDATE Member SET major = 'computer', subject = 'java/sql/jsp/spring' WHERE id='kim';
UPDATE Member SET major = 'computer', subject = 'java/sql/jsp/spring' WHERE id='lee';
UPDATE Member SET major = 'info',     subject = 'java/sql/jsp/spring' WHERE id='song';
UPDATE Member SET major = 'info',     subject = 'java/sql/jsp/spring' WHERE id='yoon';
UPDATE Member SET major = 'info',     subject = 'java/sql/jsp/spring' WHERE id='kim2';
UPDATE Member SET major = 'security', subject = 'java/sql/jsp/spring' WHERE id='yu';
UPDATE Member SET major = 'security', subject = 'java/sql/jsp/spring' WHERE id='jeon';

-- DDL 테이블 수정

-- 1. 컬럼 추가
ALTER TABLE Member ADD major VARCHAR2(20);
ALTER TABLE Member ADD subject VARCHAR2(100); --java/sql/jsp/spring
-- 2. 컬럼 수정(이름)
ALTER TABLE Member RENAME COLUMN password TO pass;
-- 3. 컬럼 수정(타입)
ALTER TABLE Member MODIFY birth DATE; 


