<%@ page language='java' contentType='text/html; charset=UTF-8'
	pageEncoding='UTF-8'%>
<jsp:include page='../global/header.jsp' />
<div class='container' style='margin: auto;'>
	<div class="row display-table">
    <div class="col-xs-12 col-sm-4 display-cell" >
	    <ul class="nav nav-pills nav-stacked">
	    	<li class="dropdown active"><a onclick="opr.sysout()">배열출력</a></li>
	    	<li><a onclick="opr.score()">어벤저스</a></li>
	    	<li><a onclick="opr.grade()">성적계산기</a>	</li>
	    	<li><a onclick="opr.gender()">성별</a></li>
	    	<li><a onclick="opr.bigNum()">가장 큰 수</a>	</li>
	    	<li><a onclick="opr.gugudan()">구구단</a></li>
	    	<li><a onclick="opr.oddSum()">홀/짝 합계</a></li>
	    </ul>
    </div>
    <div class="col-xs-12 col-sm-8 display-cell" id="result" style="border: 1px solid black;height: 500px">
        text
    </div>
</div>
</div>	
<script type='text/javascript'>
	var result = '';
	var opr = {
		sysout : function() {
			var arr = [ '사과', '배', '감', '귤' ];
			for ( var i in arr) {
				console.log(arr[i] + '\t');
			}
		},
		score : function() {
			var avengers = [];
			avengers.push({name:'아이언맨', kor:90, eng:90, math:90});
			avengers.push({name:'헐크', kor:80, eng:80, math:80});
			avengers.push({name:'캡틴아메리카', kor:70, eng:70, math:70});
			
			for ( var i in avengers) {
				avengers[i].getSum = function() {
					return this.kor + this.eng + this.math;
				}
				avengers[i].getAvg = function() {
					return this.getSum() / 3;
				}
				console.log('이름 : ' + avengers[i].name + '\t 합계 : ' + avengers[i].getSum() + '\t 평균 : ' + avengers[i].getAvg());
			}
			result = '========== 어벤저스 성적표 ========== <br/>';
			result += '이름\t국어\t영어\t수학\t총점\t평균 <br/>';
			result += '------------------------------- <br/>';
			for ( var i in avengers) {
				{
					with(avengers[i]){
						result+= name + ':\t' + kor + ':\t' + eng + ':\t' + math + ':\t' + getSum() + ':\t' + getAvg() +'<br/>';
					}
				}
			}
			/*
			with 키워드는 배열에 담긴 하나의 객체를 의미한다.
			즉 예를 들어,
			var iron = {name:'아이언맨', kor:90, eng:90, math:90};
			이렇게 선언된 하나의 객체를 avengers.push(iron)이라고 줄 경우,
			출력문에서 with를 사용하지 않는다면 iron.name이런식으로 일일히 명시해야 하기 때문에 with를 사용한다.
			*/
			console.log(result);
		},
		grade : function() {
			/*
			평균: 90이상 A
				80이상 B
				70이상 C
				60이상 D
				미만 F
			*/
			var str = '';
			var kor = Number(prompt('국어점수')), eng = Number(prompt('영어점수')), math = Number(prompt('수학점수'));
			var avg = (kor + eng + math) / 3;
			if(avg >= 90) {
				str='A';
			}else if(avg >= 80){
				str='B'
			}else if(avg >= 70){
				str='C'
			}else if(avg >= 60){
				str='D'
			}else {
				str='F';
			}
			document.getElementById("result").innerHTML = '점수 합계 : ' + (kor+eng+math) + '<br/>평균 : ' + avg + '<br/>학점 : ' + str;
			console.log('평균 : ' + avg + '\t학점 : ' + str);
		},
		gender : function() {
			/*
			800101-1234567일 경우 flag 값은 1이다 라고 정의함
			*/
			var gender = '';
			var ssn = prompt('800101-1234567의 형태로 입력해주세요.');
			var flag = ssn.charAt(7);
			// 일 때, 성별을 판별하는 로직을 switch - case로 완성하시오
			// 자바의 switch-case와 동일
			switch (flag) {
			case '1': case '3': gender = '남자'; break;
			case '2': case '4': gender = '여자'; break;
			default: gender='외국인'; break;
			} 
			document.getElementById("result").innerHTML = '입력한 주민번호의 성별 : ' + gender;
		},
		bigNum : function() {
			/* 80,70,60일 경우 if문으로 최대값을 구하는 로직을 완성하시오 */
			var num1 = Number(prompt('첫번째 값')), num2 = Number(prompt('두번째 값')), num3 = Number(prompt('세번째 값'));
			var bigNum = num1;
			if(num2 >= bigNum){
				bigNum = num2;
				if(num3 >= bigNum){
					bigNum = num3;
				}
			} else {
				if(num3 >= bigNum) {
					bigNum = num3;
				}
			}
			document.getElementById("result").innerHTML = '가장 큰 수 : ' + bigNum;
		},
		gugudan : function() {
			var j = prompt('단 수 입력');
			var str = '';
			for (var i = 1; i < 10; i++) {
				// 7단 구구단을 출력하시오
				str += j + ' * ' + i + ' = ' + j*i + '<br/>';
			}
			document.getElementById("result").innerHTML = j + '단 <br/>' + str;
		},
		sum1to100 : function() {
			var sum=0, i=0;
			while (i<=100) {
				/* 1부터 100까지 합을 출력하시오 */
				sum += i;
			}
			document.getElementById("result").innerHTML = '1부터 100까지의 합 : ' + sum;
		},
		oddSum : function() {
			var oddSum = 0, evenSum = 0, limit=prompt('홀/짝의 합을 구하기 위한 한계값 입력');
			// 1부터 100까지 수 중에서 홀수의 합 oddSum과
			// 짝수들의 합 evenSum을 구하시오
			for (var i = 0; i <= limit; i++) {
				if(i%2 == 0) {
					evenSum += i;						
				} else {
					oddSum += i;
				}
			}
			document.getElementById("result").innerHTML = '홀수의 합 : ' + oddSum + "<br/>짝수의 합 : " + evenSum;
		}
	}
</script>
