<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
	회원가입 폼
	<form action="${context }/member/join.do">
		<table>
			<tr>
				<td>
					<h3>아이디 :</h3>
				</td>
				<td><input type="text" name="id" value="" autofocus="autofocus" required="required"/></td>
			</tr>
			<tr>
				<td>
					<h3>비밀번호 :</h3>
				</td>
				<td><input type="password" name="password" value="" required="required"/></td>
			</tr>
			<tr>
				<td>
					<h3>비밀번호 확인 :</h3>
				</td>
				<td><input type="password" name="password_check" value="" required="required"/></td>
			</tr>
			<tr>
				<td>
					<h3>이름 :</h3>
				</td>
				<td><input type="text" name="name" value="" required="required"/></td>
			</tr>
			<tr>
				<td>
					<h3>주소 :</h3>
				</td>
				<td><input type="text" name="addr" value=""/></td>
			</tr>
			<tr>
				<td>
					<h3>생일 :</h3>
				</td>
				<td><input type="date" name="birth" value=""/></td>
			</tr>
		</table>
		<div>
			<input type="submit" value="회원가입" />
			<input type="reset" value="취소" />
		</div>
	</form>
	<form action="${context }/global/main.do">
		<input type="submit" value="홈으로"/>
	</form>
<jsp:include page="../global/footer.jsp"/>