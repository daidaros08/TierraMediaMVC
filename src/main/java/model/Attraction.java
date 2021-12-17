package model;

import java.util.HashMap;
import java.util.Map;

public class Attraction extends Product {

	private String image;
	private Integer capacity;
	private Map<String, String> errors;

	public Attraction(Integer id, String name, Integer cost, Double duration, Integer capacity, String tipe,
			String description, String image) {
		super(id, name, cost, duration, description, tipe);
		this.image = image;
		this.capacity = capacity;

	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (this.getCost() <= 0) {
			errors.put("cost", "Debe ser positivo");
		}
		if (this.getDuration() <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
		if (this.getCapacity() <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
	}

	// Agrego getters y setters de los campos nuevos

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// --------------------------------------

	public Map<String, String> getErrors() {
		return errors;
	}

	public Integer getCost() {
		return super.cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public boolean canHost(int i) {
		return this.getCapacity() >= i;
	}

	@Override
	public void host(int i) {
		this.capacity -= i;
	}

	@Override
	public String toString() {
		return "Attraction [id=" + this.getId() + ", name=" + this.getName() + ", cost=" + this.getCost()
				+ ", duration=" + this.getDuration() + ", capacity=" + this.getCapacity() + ", tipe=" + this.getTipe()
				+ ", description=" + this.getDescription() + ", image=" + this.getImage() + "]";
	}

}
