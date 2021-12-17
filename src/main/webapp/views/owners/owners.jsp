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
			<h1>Quienes creamos esta pagina?</h1>
			<h3>Argentina Programa - Yo programo 2021</h3>
			<h3>Grupo: this.getNombre();</h3>
		</div>

		<table class="table table-stripped table-hover">
		
			<thead>
			
				<tr>
					<th>Alumno</th>
					<th>Linkedin</th>
					<th>Otras Redes Sociales</th>
				</tr>
				
			</thead>
			
			<tbody>
			
				<tr>
					<th>Curzi, Angela</th>
					<th>
					<a href="https://www.linkedin.com/in/%C3%A1ngela-curzi-572372ba/" target="_blank">
					<img src="/turismo/images/LinkedIn_Logo.png" width="75" height="23"></a>
     				</th>
					<th></th>
				</tr>
				
				<tr>
					<th>Troncoso, Delfina</th>
					<th>
					<a href="https://www.linkedin.com/in/delfinatroncoso/" target="_blank">
					<img src="/turismo/images/LinkedIn_Logo.png" width="75" height="23"></a>
     				</th>
					<th></th>
				</tr>
				
				<tr>
					<th>Barnada, Diego</th>
					<th>
					<a href="https://www.linkedin.com/in/dbarnada/" target="_blank">
					<img src="/turismo/images/LinkedIn_Logo.png" width="75" height="23"></a>
     				</th>
					<th></th>
				</tr>
				
				<tr>
					<th>Cabrera, Sebastian</th>
					<th>
					<a href="https://www.linkedin.com/in/sebastian-cabrera-015242a8/" target="_blank">
					<img src="/turismo/images/LinkedIn_Logo.png" width="75" height="23"></a>
     				</th>
					<th></th>
				</tr>
				
				<tr>
					<th>Panozzo, Jeremias</th>
					<th>
					<a href="https://www.linkedin.com/in/jeremias-panozzo/" target="_blank">
					<img src="/turismo/images/LinkedIn_Logo.png" width="75" height="23"></a>
     				</th>
					<th></th>
				</tr>
	
			</tbody>
		</table>
		
		<div class="bg-light p-4 mb-3 rounded">
			
			<h3>Enlace a repositorio de GitHub del proyecto</h3>
			
			<a href="https://github.com/daidaros08/TierraMediaMVC" target="_blank">https://github.com/daidaros08/TierraMediaMVC</a>
		</div>
		
		

	</main>
	

</body>
</html>