<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
	<div class="mg_auto" style="width:1000px;">
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
	<div>
		<form action="${context }/grade/my_grade.do">
			<input type="submit" value="내 성적 보기" />
		</form>
		<form action="${context }/global/main.do">
			<input type="submit" value="로그아웃" />
		</form>   
	</div>
	
</div>
<jsp:include page="../global/footer.jsp"/>