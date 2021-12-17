<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta name="viewport" content="width=device-width, initial-scale=1">

		<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">

			<div class="carousel-inner">
  			<div class="carousel-item active">
				<img src="/turismo/images/Carrousel.jpg" class="d-block w-100" alt="Mostrar FOTO1">
				<div class="carousel-caption d-none d-md-block">
				  <h2 class="bg-dark">Tierra MEDIA</h2>
				  <p>Busca tu atraccion preferida >>></p>
				</div>
			  </div>
			  

			<c:forEach items="${attractions}" var="publicidad">

			  
			  
			  <div class="carousel-item">
				<img src="${publicidad.image}" class="d-block w-100" alt="Mostrar FOTO2">
				<div class="carousel-caption d-none d-md-block">
				  <h2><c:out value="${publicidad.name}"></c:out></h2>
				  <p><c:out value="${publicidad.description}"></c:out></p>

				</div>
			  </div>
		
			  
			  </c:forEach>
			  

			  
			</div>
			
			<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			  <span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			  <span class="carousel-control-next-icon" aria-hidden="true"></span>
			  <span class="visually-hidden">Next</span>
			</button>
		  </div>