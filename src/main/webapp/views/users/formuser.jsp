<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal-body">

	<div class="mb-3">
		<label for="username" class="col-form-label">Nombre Usuario:</label>
		 <input	type="text" class="form-control" id="username" name="username"
			required value="${user.username}"></input>
	</div>

	<div class="mb-3">
		<label for="password" class="col-form-label">Password:</label>
		 <input	type="text" class="form-control" id="password" name="password"
			required value="${user.password}"></input>
	</div>


	<div class="mb-3">
		<label for="coins" class='col-form-label'>Monedas:</label>
		<%--FALTA implementar control --%>
		<input class="form-control" type="number" id="coins" name="coins"
		required value="${user.coins}"></input>
	</div>

	<div class="mb-3">
		<label for=time class='col-form-label'>Tiempo:</label>
		<%--FALTA implementar controles --%>
		<input class="form-control" type="number" id="time" name="time"
		required value="${user.time}"></input>

	</div>

	<div class="mb-3">
		<label for="prefer" class="col-form-label">Preferencias</label> 
		<select class="form-control" id="prefer" name="prefer"
		 required>
		 <option value="Aventura">Aventura</option>
		 <option value="Paisaje">Paisaje</option>
		 <option value="Degustacion">Degustacion</option>
		 </select>
	</div>



</div>


	<div>
		<button type="submit" class="btn btn-primary">Guardar</button>
		<a onclick="window.history.back();" class="btn btn-secondary"
			role="button">Cancelar</a>
	</div>
