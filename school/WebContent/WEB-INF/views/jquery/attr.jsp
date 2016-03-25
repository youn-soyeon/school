<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div class="container" style="margin: auto">
	<button id="callImg">이미지 불러오기</button>
	<button id="htmlDemo">html() 테스트</button>
	<button id="textDemo">text() 테스트</button>
	<div id="sampleBox1" style="border: 1px solid black; width: 300px; height: 300px">
		샘플 박스 1
	</div>
	<div id="sampleBox2" style="border: 1px solid black; width: 300px; height: 300px">
		샘플 박스 2
	</div>
	<div id="sampleBox3" style="border: 1px solid black; width: 300px; height: 300px">
		샘플 박스 3
	</div>
	<div id="sampleBox4" style="border: 1px solid black; width: 300px; height: 300px">
		샘플 박스 4
	</div>
</div>

<!-- 자바 스크립트 영역  -->
<script src="${context }/resources/js/attr.js"></script>  <!-- 자바에서 import만 한 것과 같다 -->
<script type="text/javascript">
	// 자바의 메인 메소드와 같다
	// documnent가 완성되면 이 함수를 자동으로 실행핼자바의 메인 메소드와 같다
	$(document).ready(function() {
		alert('콜백함수가 실행되었습니다 !!'); // dom객체의 메서드, 앞에 window생략, 함수아닌 메서드개념임
		$('#callImg').click(function() {
			attr.attrDemo('${context}/resources/img/main/hi.jpg');
		});
		$('#sampleBox1').mouseover(function() {
			attr.attrDemo('${context}/resources/img/member/heart.png');
		});
		$('#htmlDemo').click(function() {
			attr.htmlDemo('#sampleBox2');
		});
		$('#textDemo').click(function() {
			attr.textDemo('#sampleBox3');
		})
	});
</script>