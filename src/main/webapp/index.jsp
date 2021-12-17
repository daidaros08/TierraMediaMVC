<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
<div class="bg-image" style="background-image: url('https://pod.museoteca.com/oxford/img/web/images/00406.jpg');
    height: 100vh; width: auto; " >
	<jsp:include page="partials/nav.jsp"></jsp:include>

	<main class="container">
	
		<div class="bg-light p-4 rounded">
			<h1>
				¡Bienvenido, <c:out value="${user.username}" />!
			</h1>
			
		</div>
		<div class="bg-image" style="background-image: url('https://key0.cc/images/small/6540_2c8e9e47500a1bfeebd476184d428f74.png');
    height: 38vh; width: 200px; margin-left: 500px; " > </div>
	</main> </div>
	
	
	
</body>
</html>