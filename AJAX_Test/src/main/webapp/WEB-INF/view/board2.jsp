<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>#</th>
				<th>이름</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody id="tbody">
			<c:forEach var="l" items="${p }">
				<tr>
					<td>${l.idx }</td>
					<td>${l.name }</td>
					<td>${l.title }</td>
					<td>${l.writeDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type="button" onclick="board_ajax_2()">더 보기</button>
	
	
	
	<script type="text/javascript">
		var mark = 2;	// 다음 불러올 게시글은 LIMIT 2, 2 니까 미리 2로 세팅
	
		function board_ajax_2() {
			$.ajax({
				type: 'POST', 
				url: '${pageContext.request.contextPath}/board_ajax_2', 
				data: {mark : mark}, 
				success: function(result) {
					if(result.length != 0) {	
						// 못불러왔을 경우 null 값을 줘서 != null 로도 해봤는데
						// "" 이 값으로 리턴되는 것 같다.
						// 길이로 판단하니 잘 작동
						
						// 해당 id의 태그에 받아온 string 추가
						$("#tbody").append(result);
						// 제대로 불러왔을 경우, 다음 불러올 데이터를 위해
						mark += 2;
					} else {
						alert("불러올 데이터가 없습니다.");
						return false;
					}
				}, 
				error: function() {
					alert("ajax 통신 에러");
				}
			})
		}
	</script>


</body>
</html>