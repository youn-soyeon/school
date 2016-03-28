<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="admin_header.jsp" />

<div class='container' style='margin: auto;'>
	<div class="row display-table">
	    <div class="col-xs-12 col-sm-4 display-cell" >
		    <ul id="admin_sidebar" class="nav nav-pills nav-stacked">
		    	<li class="dropdown active">
		    		<a onclick="admin.memberList()">전체 학생 보기</a>
		    	</li>
		    	<li><a onclick="admin.gradeList()">전체 성적 보기</a></li>
		    	<li><a onclick="admin.searchById()">ID로 회원 검색</a>	</li>
		    	<li><a onclick="admin.searchByName()">이름으로 회원 검색</a></li>
		    	<li><a onclick="admin.addScore()">학생 점수 입력</a></li>
		    </ul>
	    </div>
	    <div class="col-xs-12 col-sm-8 display-cell" id="result" style="border: 1px solid black;height: 500px">
	        <jsp:include page="../member/member_list.jsp"/>
	    </div>
	</div>
</div>	
<script src="${context }/resources/js/admin.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#admin_sidebar').children().first().addClass('dropdown active');
		$('#admin_sidebar').children().click(function() {
			$(this).addClass('dropdown active');
			$(this).siblings().removeClass('dropdown active');
		});
	});
	var admin = {
			memberList : function() {
				$('result').location.href='${context}/admin/member_list.do';
			},
			gradeList : function() {
				$('result').location.href='${context}/admin/grade_list.do';
			}
	}
</script>
