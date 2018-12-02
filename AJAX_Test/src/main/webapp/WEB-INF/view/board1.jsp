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

	<button type="button" onclick="board_ajax_1()">board_ajax_1</button>
	
	
	
	<script type="text/javascript">
		function board_ajax_1() {
			$.ajax({
				type: 'POST', 
				url: '${pageContext.request.contextPath}/board_ajax_1', 
				dataType: 'JSON', 
				data: {idx : 4}, 
				success: function(result) {
					// result -> json 형태인데 key 에 해당하는 부분을 아래와 같이 쓸 경우
					// value 에 해당하는 부분이 출력됨.
					alert(result.idx);
					alert(result.name);
					alert(result.title);
					alert(result.writeDate);
				}, 
				error: function() {
					alert("ajax 통신 에러");
				}
			})
		}
	</script>


</body>
</html>