<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>상품명</th>
				<th>제조사</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<c:forEach items="${list}" var="myProduct">
					<td>
						<p>${list.name}</p>
					</td>
				</c:forEach>
			</tr>
		</tbody>
	
	</table>
</body>
</html>