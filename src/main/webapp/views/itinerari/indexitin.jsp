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
		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Aqui esta su itinerario, que lo disfrute!</h1>
		</div>

		<c:if test="${user.isAdmin()}">
			
	
					
		</c:if>
		
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Itinerario</th>
					<th>Usuario</th>
					<th>Comprado</th>
					<th>Preferencia</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${itinerari}" var="itinerari">
				
					<tr>
						<td><strong><c:out value="${itinerari.id_itinerari}"></c:out></strong></td>
						<td><c:out value="${itinerari.id_user}"></c:out></td>
						
						<td><c:out value="${itinerari.id_attraction}"></c:out></td>
						
						<td><c:out value="${user.prefer}"></c:out></td>
						
						<!-- 
						<td>
								<a href="/turismo/users/editusers.do?id=${user.id}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i></a>
									
								<a href="/turismo/users/delete.do?id=${user.id}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill"></i></a>

							</td>
						 -->
					</tr>
					
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>