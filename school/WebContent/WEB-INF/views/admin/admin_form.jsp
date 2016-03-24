<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="admin_header.jsp" />

<div class="mg_auto" style="width: 1000px;">
	<form action="">
	<fieldset>
	<legend>회원관리</legend>
		<table class="table-condensed" style="width: 90%; margin-left: 50px">
			<tr>
				<td>전체 회원 목록 보기</td>
				<td>
					<jsp:include page="member_list.jsp"/>
				</td>
			</tr>
			<tr>
				<td>ID로 회원 검색</td>
				<td>
					<input type="text" id="searchById" name="serachById"/>
				</td>
			</tr>
			<tr>
				<td>이름으로 회원 검색</td>
				<td>
					<input type="text" id="searchByName" name="searchByName"/>
				</td>
			</tr>
			<tr>
				<td>학생 점수 입력</td>
				<td>
					<jsp:include page="member_list.jsp"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button>전송</button>
					<button>취소</button>
				</td>
			</tr>
		</table>
		</fieldset>
	</form>
</div>

<jsp:include page="../global/footer.jsp" />