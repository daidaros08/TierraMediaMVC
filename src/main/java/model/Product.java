package model;

public abstract class Product {
	private Integer id;
	private String name;
	protected Integer cost;
	protected Double duration;
	private String description;
	private String tipe;

	public Product(Integer id, String name, Integer cost, Double durat, String description, String tipe) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.duration = durat;
		this.description = description;
		this.tipe = tipe;

	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;

	}

	public abstract Integer getCost();

	public abstract Double getDuration();

	public String getTipe() {
		return this.tipe;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTipe(String tipe) {
		this.tipe = tipe;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public abstract boolean canHost(int i);

	public abstract void host(int i);
}
