<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>

<style type="text/css">
	div{
		margin-bottom: 60px
	}
</style>

	<div>
		<button type="button" onclick="ajaxTest1()">click!</button>
		<span>
			ajax 로 restController 에 값 보내고 객체 json 형태로 받아보기 테스트
		</span>
	</div>
	
	<div>
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/board1'">board 테스트 1</button>
		<span>
			파라미터값으로 보낸 idx 로 해당 게시글 하나 가져오기
		</span>
	</div>
	
	<div>
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/board2'">board 테스트 2</button>
		<span>
			ajax 로 버튼 눌러서 나머지 게시글 불러오기
		</span>
	</div>
	


	
	<script type="text/javascript">
		function ajaxTest1() {
			$.ajax({
				type: 'POST', 
				url: '${pageContext.request.contextPath}/ajaxTest1', 
				dataType: 'JSON', 
				data: {value : "abc"}, 
				success: function(result) {
					alert(result.id);
					alert(result.pw);
					alert(result.name);
				}, 
				error: function() {
					alert("ajax 통신 에러");
				}
			})
		}
	</script>

</body>
</html>