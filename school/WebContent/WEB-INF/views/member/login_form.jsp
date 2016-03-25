<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
	<style type="text/css">
		#login{
			margin-top: 5em;
		}
	</style>

	<div id="login">
		<div class="loginTop text-center" >
			<img src="${context}/resources/img/member/heart.png" id="heart"/>
		</div>
		<form class="form-horizontal">
		<div class="loginCenter row" style="margin-left: 43.5%;">
				<fieldset class="loginField">
					<div class="form-group">
					 	<label for="input_id" class="control-label sr-only">아이디</label>
					 	<div class="col-sm-3">
							<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="control-label sr-only">비밀번호</label>
					 	<div class="col-sm-3">
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요"/>
						</div>
					</div>
				</fieldset>
			
		</div>
		</form>
		<div class="input_button text-center">
			<button id="loginButton">로그인</button>
		</div>
	</div>
</body>
<script>
	$(function() {
		
		$('#heart').css('border','0').css('height','160px').css('width','300px');
		$form = $('form');
		$form.addClass('form-horizontal').attr('method','post').attr('action', '${context}/member/login.do');
		$('#loginButton').click(function() {
			$form.submit();
			});
		});
</script>
</html>