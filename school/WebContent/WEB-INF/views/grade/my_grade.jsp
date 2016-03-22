<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />

<div align="center">
	<table border=1>
		<tr>
			<td><h3>과목</h3></td>
			<td><h3>점수</h3></td>
		</tr>
		<tr>
			<td>Java</td>
			<td>${score.java }</td>
		</tr>
		<tr>
			<td>SQL</td>
			<td>${score.sql }</td>
		</tr>
		<tr>
			<td>JSP</td>
			<td>${score.jsp }</td>
		</tr>
		<tr>
			<td>Spring</td>
			<td>${score.spring }</td>
		</tr>
	</table>
</div>

<jsp:include page="../global/footer.jsp" />