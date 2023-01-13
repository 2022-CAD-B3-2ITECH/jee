<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue sur Super Cat</title>
</head>
<body>
	
	<%@ include file="partials/menu.jsp" %>
	
	<h1>Des photos de chats</h1>
	<p>Parce que c'est ça, un vrai site web.</p>
	
	<div style="display:flex; margin-top: 50px;">
		
		<div style="margin-right:10px;">
			<img src="${ felix.img }" width="300" height="250" />
			<p>${ felix.nom } - ${ felix.estSortable ? "est sortable" : "n'est pas sortable" }
			</p>
			
		</div>
		
		<div style="margin-right:10px;">
			<img src="${ willow.img }" width="300" height="250" />
			<p>${ willow.nom } - ${ willow.estSortable ? "est sortable" : "n'est pas sortable" }</p>
		</div>
		
		<div style="margin-right:10px;">
			<img src="${ alba.img }" width="300" height="250" />
			<p>${ alba.nom } - ${ alba.estSortable ? "est sortable" : "n'est pas sortable" }</p>
		</div>
	
	</div>
	
</body>
</html>