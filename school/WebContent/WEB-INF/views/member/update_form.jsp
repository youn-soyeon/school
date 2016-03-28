<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="update">
		<div class="joinTop">
			<!-- ${user.name } => ${sessionScope.user.name} -->
			<h2 class="text-center">${user.name } 정보 수정 페이지</h2>
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
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="password" class="form-control" id="password" name="password" value="${user.password }"/>
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
							<input type="text" class="form-control" id="addr" name="addr" value="${user.addr }"/>
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
				<button id="updateButton">수정하기</button>
				<button id="myGradeButton">내 성적 보기</button>
				<button id="cancleButton">취소</button>
			</div>
		</div>
	</div>
	
	<script>
	$(function() {
		$form = $('form');
		$form.addClass('form-horizontal').attr('method','post').attr('action','${context}/member/update.do');
		$('#updateButton').addClass('btn btn-primary').click(function() {
			$form.submit();
		});
		$('#cancleButton').addClass('btn btn-primary').click(function() {
			$form.reset();
		});
		
	});
	
	
	</script>