/**
 * jQuery 속성 예제
 */

// var test = {} // null 객체와 같다
var attr = {
	attrDemo : function(imgPath) {
		// {src:imgPath,width:'100%',height:'100%'}의 의미
		// 한번 쓰고 버릴건데 굳이 이름 붙일 필요가 없어서 바로 이름없는 객체를 넣어줌
		// 즉, javascript의 노드가 됨
		$('<img/>',{src:imgPath,width:'100%',height:'100%'}).appendTo($('#sampleBox1').empty());
	},
	htmlDemo : function(target) {
		// 여기서 id뒤에 single quote를 주면 끊겨버림
		// 반대로 "<div id=''></div>"이것도 사용 가능
		// 두가지를 구분해주어야 함.
		$('<div id="htmlBox"></div>').appendTo($(target).empty()); // sampleBox비우기
		//html() : html코드가 바로 적용되는 메소드
		$('#htmlBox').html('<div style="background-color: yellow; width: 100px; height:100px;">노란 박스</div>');
	},
	textDemo : function(target) {
		$('<div id="textBox"></div>').appendTo($(target).empty()); // sampleBox비우기
		$('#textBox').html('노란 박스');
	}
}