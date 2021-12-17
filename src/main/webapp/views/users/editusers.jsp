<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${attraction != null && !attraction.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al actualizar la atracción.</p>
			</div>
		</c:if>

		<form action="/turismo/users/editusers.do" method="post">
			<input type="hidden" name="id" value="${user.id}">
			<jsp:include page="/views/users/formuser.jsp"></jsp:include>
		</form>
	</main>
	
	
		<jsp:include page="/partials/foot.jsp"></jsp:include>
	
</body>
</html>
