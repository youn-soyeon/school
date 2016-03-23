-- v_grade : Grade의 View를 뜻함
-- 보안문제로 table에 접근 못하게 하도록 함
-- view인지 아닌지도 모르게 함

-- REPLACE : 오버라이딩 개념 - 재정의(덮어쓰기)
CREATE OR REPLACE VIEW GradeMember
AS
SELECT 
	g.score_seq as score_seq,
	g.id as id,
	g.java as java,
	g.sql as sql,
	g.jsp as jsp,
	g.spring as spring,
	m.name as name,
	m.password as password,
	m.addr as addr,
	m.birth as birth
FROM Member m, Grade g
WHERE m.id = g.id;

SELECT * FROM GradeMember;

SELECT * FROM GradeMember
WHERE name = '김유신';

SELECT * FROM GradeMember
WHERE id = 'hong';

DROP VIEW GradeMember;

SELECT COUNT(*) FROM GradeMember;
