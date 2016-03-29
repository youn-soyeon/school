<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<h3>${member.name} 성적 입력</h3>
<form>
	<table id = "input_table" style="width: 100%; margin-top: 30px">
		<tr style="background-color: yellow">
			<th>Java</th>
			<th>SQL</th>
			<th>JSP</th>
			<th>Spring</th>
		</tr>
		
		<tr>
			<td><input type="text" id="java" name="java" /></td>
			<td><input type="text" id="sql" name="sql"/></td>
			<td><input type="text" id="jsp" name="jsp"/></td>
			<td><input type="text" id="spring" name="spring"/></td>
			<td><input type="hidden" id="id" name="id" value="${member.id}"/></td>
		</tr>
		<tr>
			<td colspan="4">
				<button id="grade_input">입 력</button>
				<button id="grade_cancle">취 소</button>
			</td>
		</tr>
	</table>
</form>


<script>
	$(function() {
		$('#input_table').css('border','1px solid black').css('align','center').css('text-align','center');
		$('#input_table th').css('border','1px solid black').css('text-align','center');
		$('#input_table tr').css('border','1px solid black').css('text-align','center');
		$('#input_tablet tr td').css('border','1px solid black').css('text-align','center');
		
		$('#grade_input').addClass('btn btn-primary').click(function() {
			$('form').attr('action','${context}/grade/add.do').submit();
		});
		$('#grade_cancle').addClass('btn btn-primary').click(function() {
			$('form').reset();
		});
	});
</script>