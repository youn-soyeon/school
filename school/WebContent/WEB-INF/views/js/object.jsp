<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div class="container" style="width: 1000px; margin:0 auto">
	<div>
		<h3>자바 스크립트는 객체기반 언어이다.</h3>
		자바는 객체지향 언어 이다. <br />
		객체기반 언어와 객체지향 언어의 다른 점은 객체를 표현하는 데 있어서 <br />
		클래스(객체의 정의)와 인스턴스(객체의 실체)를 정확히 구분하는가와 <br />
		구분하지 않는가 이다. <br />
		객체기반언어에서는 정의하는 클래스가 존재하지 않아도 객체로 명명함 <br />
		자바 스크립트에서는 객체를 노드라고 한다
	</div>
	<div style="margin-top: 30px">
		<h3>객체 구분</h3>
		<ol>
			<li>기본 객체 : String, Math, Data, Array</li>
			<li>내장 객체 : 브라우저 객체, 다큐먼트 객체</li>
			<li>사용자 정의 객체</li>
		</ol>
	</div>
	<div style="margin-top: 30px">
		<h3>브라우저 객체 BOM(Browser Object Model)</h3>
		웹 브라우저는 최초 HTML 문서를 로드하면서 HTML 문서에 관계없이 <br />
		5개의 브라우저객체(BOM)을 생성한다. <br />
		<ol>
			<li>Window</li>
			<li>Document</li>
			<li>Location</li>
			<li>Navigation</li>
			<li>History</li>
		</ol>
		<br />
		<h4>
			즉, 브라우저 객체(BOM = Window 객체)는 <br />
			브라우저 창이 열릴 때마다 하나씩 만들어지는 객체로서 <br />
			브라우저 창 안에 존재하는 모든 요소(객체)들의 상위 객체이다. <br />
			window.alert(); 처럼 사용하나 <br />
			window 객체는 생략이 가능하고 보통 생략해서 쓴다. <br />
		</h4>
		<br />
	</div>
	<div style="margin-top: 30px">
		<h3>자바에서 객체 생성 방법</h3>
		<ul>
			<li>생성자 : Account a = new Account();</li>
			<li>딥카피 : MemberSevice m = new MemberServiceImpl();</li>
			<li>쉘로우카피 : MemberService m = new MemberServiceImpl.getInstance();</li>
		</ul>	
		<h3>자바 스크립트에서 객체 생성 방법</h3>
			<ul>
				<li>생성자함수 : var obj = new Object()</li>
				<li>객체리터럴 : var foo = { var opr : function(){} }</li>
				<li>함수표현식 : var func = function(){}</li>
			</ul>
	</div>
</div>