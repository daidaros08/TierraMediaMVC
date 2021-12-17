<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">

	<div class="mb-3">
		<label for="tipe" class="col-form-label">Tipo Promocion</label> <input
			type="text" class="form-control" id="offerClass" name="offerClass"
			></input>
	</div>

	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre Promocion</label> <input
			type="text" class="form-control" id="name" name="name"
			></input>
	</div>
	
	<div class="mb-3">
		<label for="tipe" class="col-form-label">Tipo Promocion</label> <input
			type="text" class="form-control" id="tipe" name="tipe"
			></input>
	</div>
	
	
	<div class="mb-3">
		<label for="tipe" class="col-form-label">Atraccion 1</label> <input
			type="text" class="form-control" id="atr1" name="atr1"
			></input>
	</div>
	
	<div class="mb-3">
		<label for="tipe" class="col-form-label">Atraccion 2</label> <input
			type="text" class="form-control" id="atr2" name="atr2"
			></input>
	</div>
	
	<div class="mb-3">
		<label for="tipe" class="col-form-label">Atraccion Gratis</label> <input
			type="text" class="form-control" id="freeatr" name="freeatr"
			></input>
	</div>
	
	<div class="mb-3">
		<label for="cost"
			class='col-form-label'>Porcentaje Descuento</label>
		<input class="form-control" type="number" id="percent" name="percent"
			value="0"></input>

	</div>
	
	<div class="mb-3">
		<label for="cost"
			class='col-form-label'>Precio Absoluto</label>
		<input class="form-control" type="number" id="abs" name="abs"
			value="0"></input>
	</div>
	
		<div class="mb-3">
		<label for="description" class="col-form-label">Descripcion Promo</label> <input
			type="text" class="form-control" id="description" name="description"
			>
	</div>
	
	

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
