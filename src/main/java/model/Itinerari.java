package model;

public class Itinerari {
	
	
	private Integer id_itinerari;
	private Integer id_user;
	private Integer id_attraction;

	public Itinerari(Integer id_itinerari, Integer id_user, Integer id_attraction) {
		super();
		this.id_itinerari = id_itinerari;
		this.id_user = id_user;
		this.id_attraction = id_attraction;
	}

	@Override
	public String toString() {
		return "Itinerari [id_itinerari=" + id_itinerari + ", id_user=" + id_user + ", id_attraction=" + id_attraction
				+ "]";
	}

	public Integer getId_itinerari() {
		return id_itinerari;
	}

	public void setId_itinerari(Integer id_itinerari) {
		this.id_itinerari = id_itinerari;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_attraction() {
		return id_attraction;
	}

	public void setId_attraction(Integer id_attraction) {
		this.id_attraction = id_attraction;
	}

}

