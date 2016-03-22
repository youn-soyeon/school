<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="<%=request.getContextPath()%>"></c:set>
<jsp:include page="../global/header.jsp"/>

		<table border="1">
		<tr>
			<td rowspan="4"></td>
			<td>
				<h6>아이디</h6>
			</td>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<td>
				<h6>이름</h6>
			</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>
				<h6>비밀번호</h6>
			</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td>
				<h6>주소</h6>
			</td>
			<td><input type="text" name="addr" /></td>
		</tr>
		<tr>
			<td><input type="file" value="파일" /></td>
			<td>
				<h6>생년월일</h6>
			</td>
			<td><input type="date" name="birth" /></td>
		</tr>
	</table>
	<form action="${context }/global/main.do">
		<input type="submit" value="로그아웃" />
	</form>   

<jsp:include page="../global/footer.jsp"/>