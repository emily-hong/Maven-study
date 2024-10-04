<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품등록</h2>
	<form action="addProduct.do" method="post">
		상품명 : <input type="text" name="name" id="name"/>
		제조사 : <input type="text" name="maker" id="maker">
		가격 : <input type="number" name="price" id="price">
		<input type="submit" value="상품등록">
	</form>
	<br>
	<br>	
	<h2>상품명 (제조사별) 검색하기</h2>
	<form action="searchProduct.do" method="post">
		<select name="searchOption">
			<option value="all">전체 검색</option>
			<option value="name">상품명으로 검색</option>
			<option value="maker">브랜드명으로 검색</option>
		</select>
		<input type="text" name="keyword" />
		<input type="submit" value="상품검색">
	</form>
	
</body>
</html>
