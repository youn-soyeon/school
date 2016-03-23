<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
	<div>
		<table >
		<tr>
			<td rowspan="4"></td>
			<td>
				<h6>아이디</h6>
			</td>
			<td><input type="text" value="${member.id}"/></td>
		</tr>
		<tr>
			<td>
				<h6>이름</h6>
			</td>
			<td><input type="text" value="${member.name}" /></td>
		</tr>
		<tr>
			<td>
				<h6>비밀번호</h6>
			</td>
			<td><input type="password" value="${member.password}" /></td>
		</tr>
		<tr>
			<td>
				<h6>주소</h6>
			</td>
			<td><input type="text" value="${member.addr}" /></td>
		</tr>
		<tr>
			<td><input type="file" value="파일" /></td>
			<td>
				<h6>생년월일</h6>
			</td>
			<td><input type="text" value="${member.birth}" /></td>
		</tr>
	</table>
	<div>
		<form action="${context }/grade/my_grade.do?id=${member.id}">
			<input type="hidden" name="id" value="${member.id }" />
			<input type="submit" value="내 성적 보기" />
		</form>
		<form action="${context }/global/main.do">
			<input type="submit" value="로그아웃" />
		</form>   
	</div>
	
</div>
<jsp:include page="../global/footer.jsp"/>