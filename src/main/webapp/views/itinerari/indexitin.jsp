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


		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Atracciones Compradas</th>
					<th>Costo</th>
					<th>Tiempo</th>
				
				</tr>
			</thead>
			
			
			
<tbody>
				
			
				
				<c:forEach items="${itinerari}" var="itinerari">
					
					<c:set var="total" value="${total + itinerari.cost}"/>
					<c:set var="totime" value="${totime + itinerari.duration}"/>
					
					<tr>
						<td><c:out value="${itinerari.name}"></c:out></td>
						<td><c:out value="${itinerari.cost}"></c:out></td>
						<td><c:out value="${itinerari.duration}"></c:out></td>
					</tr>
					
				</c:forEach>
				
				<tr>
				
				<td><strong>Total de su compra en monedas y duracion</strong></td>
				
				<td><c:out value="${total}"></c:out></td>
				<td><c:out value="${totime}"></c:out></td>
			
				
				</tr>

			</tbody>
		</table>

	</main>
	<jsp:include page="/partials/foot.jsp"></jsp:include>
</body>
</html>