<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../member/member_header.jsp"/>
<div id="detail">
		<div class="joinTop">
			<h2 class="text-center">${user.name }회원 상세 정보</h2>
		</div>
		<div class="joinCenter row">
			<form>
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${user.id }" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
					 	<input type="text" class="form-control" id="name" name="name" value="${user.name }" readonly="readonly"/>
							
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
					 	<input type="text" class="form-control" id="addr" name="addr" value="${user.addr }" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
					 	<input type="text" class="form-control" id="birth" name="birth" value="${user.birth }" readonly="readonly"/>
						</div>
					</div>
				</fieldset>
			</form>
			<div class="input_button text-center">
				<button id="updateFormButton">수정 폼으로 이동</button>
				<button id="deleteButton">회원 탈퇴</button>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			$('form').addClass('form-horizontal');
			$('#updateFormButton').addClass('btn btn-primary').click(function() {
				location.href='${context}/member/update_form.do';
			});
			$('#deleteButton').addClass('btn btn-primary').click(function() {
				location.href='${context}/member/delete.do';
			});
		});
	</script>