<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id = "gradeMember_list" style="width: 100%; margin-top: 30px">
	<tr style="background-color: yellow">
		<th>아이디</th>
		<th>이름</th>
		<th>Java</th>
		<th>Sql</th>
		<th>Jsp</th>
		<th>Spring</th>
	</tr>
	
	<c:forEach items="${list}" var="gradeMember" >
		<tr>
			<td>${gradeMember.id }</td>
			<td>${gradeMember.name}</td>
			<td>${gradeMember.java }</td>
			<td>${gradeMember.sql }</td>
			<td>${gradeMember.jsp }</td>
			<td>${gradeMember.spring }</td>
		</tr>
	</c:forEach>
</table>
<script>
	$(function() {
		$('#gradeMember_list').css('border','1px solid black').css('align','center').css('text-align','center');
		$('#gradeMember_list th').css('border','1px solid black').css('text-align','center');
		$('#gradeMember_list tr').css('border','1px solid black').css('text-align','center');
		$('#gradeMember_list tr td').css('border','1px solid black').css('text-align','center');
	});
</script>