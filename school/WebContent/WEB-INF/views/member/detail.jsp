<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="detail">
		<div class="joinTop">
			<h2 class="text-center">회원 상세 정보</h2>
		</div>
		<div class="joinCenter row">
			<form>
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${member.id }" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
					 	<input type="text" class="form-control" id="name" name="name" value="${member.name }" readonly="readonly"/>
							
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
					 	<input type="text" class="form-control" id="addr" name="addr" value="${member.addr }" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
					 	<input type="text" class="form-control" id="birth" name="birth" value="${member.birth }" readonly="readonly"/>
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
			$form=$('form');
			$form.addClass('form-horizontal');
			//$form.addClass('form-horizontal').attr('method','post').attr('action','${context}/member/update_form.do');
			$('#updateFormButton').addClass('btn btn-primary').click(function() {
				$form.attr('method','post').attr('action','${context}/member/update_form.do').submit();
			});
			$('#deleteButton').addClass('btn btn-primary').click(function() {
				$form.addClass('form-horizontal').attr('method','post').attr('action','${context}/member/delete.do').submit();
				//location.href='${context}/member/delete.do?id=${member.id}';
			});
		});
	</script>