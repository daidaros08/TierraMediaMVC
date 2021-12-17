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
			<h1>Disfruta las siguientes Promos y ahorra monedas!</h1>
		</div>

		
		
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					
					<th>Atracci&oacute;n</th>
					<th>Descripcion</th>
					<th>Tipo</th>
					<th>Costo</th>
					<th>Tiempo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			
			<tbody>
			
				<c:forEach items="${offer}" var="offer">
					
					<tr>
						<td><strong><c:out value="${offer.name}"></c:out></strong></td>
						
						<td>
						<c:out value="${offer.description}"></c:out>
						<br>
						<strong>Atracciones Incluidas:</strong>
						<c:forEach items="${offer.attractionsInclude}" var="include">
						<c:out value="${include.name}"></c:out>/
						</c:forEach>
						</td>
						
						<td><c:out value="${offer.tipe}"></c:out></td>
						<td><c:out value="${offer.cost}"></c:out></td>
						<td><c:out value="${offer.duration}"></c:out></td>
						
						
						
						<td>
						<c:if test="${user.admin}">
								<a href="/turismo/offer/edit.do?id=${offer.id}"
									class="btn btn-light rounded-0 disabled" role="button"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="/turismo/offer/deleteoffer.do?id=${offer.id}&offerClass=${offer.offerClass}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill"></i></a>
						</c:if> 

							
							<c:choose>
								
								<c:when test="${user.canAfford2(offer) && user.canAttend2(offer)&& offer.canHost(1)}">
									<a href="/turismo/offer/buyoffer.do?id=${offer.id}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose>

						</td>
	
					</tr>

					
				</c:forEach>
			</tbody>
		</table>
		
		<c:if test="${user.isAdmin()}">
			
			<div class="mb-3">
				<a href="/turismo/offer/createoffer.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Crear nueva PROMOCION
				</a>
				
			</div>
			
			
		</c:if>
		

	</main>

	<jsp:include page="/partials/foot.jsp"></jsp:include>
</body>
</html>