<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="admin_header.jsp" />

<div class='container' style='margin: auto;'>
	<div class="row display-table">
	    <div class="col-xs-12 col-sm-4 display-cell" >
		    <ul id="admin_sidebar" class="nav nav-pills nav-stacked">
		    	<li class="dropdown active">
		    		<a href="#" id="member_list">전체 학생 보기</a>
		    	</li>
		    	<li>
		    		<a href="#" id="grade_list">전체 성적 보기</a>
		    	</li>
		    </ul>
	    </div>
	    <div class="col-xs-12 col-sm-8 display-cell" id="result" style="border: 1px solid black;height: 500px">
	        <%-- <jsp:include page="../member/member_list.jsp"/> --%>
	    </div>
	</div>
</div>	
<script src="${context }/resources/js/admin.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#result').load('${context}/member/list.do');
		$('#admin_sidebar').children().first().addClass('dropdown active');
		$('#admin_sidebar').children().click(function() {
			$(this).addClass('dropdown active');
			$(this).siblings().removeClass('dropdown active');
		});
		$('#member_list').click(function() {
			$('#result').empty();
			$('#result').load('${context}/member/list.do');
		});
		$('#grade_list').click(function() {
			$('#result').empty();
			$('#result').load('${context}/grade/list.do');
		});
		$('#grade_regist').click(function() {
			$('#result').empty();
			/* insert하는 폼만 가져오기 add이기때문 */
			$('#result').load('${context}/grade/grade_add.do');
		});
	});
	/* var admin = {
			memberList : function() {
				$('result').location.href='${context}/admin/member_list.do';
			},
			gradeList : function() {
				$('result').location.href='${context}/admin/grade_list.do';
			}
	} */
</script>
