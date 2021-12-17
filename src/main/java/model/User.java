package model;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

import utils.Crypt;

public class User {

	private Integer id;
	private String username, password;
	private Boolean admin;
	private Integer coins;
	private Double time;
	//Agrego preferencias
	private String prefer;
	
	public User(Integer id, String username, String password, Integer coins, Double time, Boolean admin, String prefer) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.coins = coins;
		this.time = time;
		this.admin = admin;
		//Agrego preferencias
		this.prefer=prefer;
		
	}
	
	public User(Integer id, String username, String password, Integer coins, Double time, Boolean admin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.coins = coins;
		this.time = time;
		this.admin = admin;
		
	}
	
	
	
	

	public void addToItinerary(Attraction attraction) {
		this.coins -= attraction.getCost();
		this.time -= attraction.getDuration();
		// TODO agregar a su lista
	}

	public boolean canAfford(Attraction attraction) {
		return attraction.getCost() <= this.coins;
	}

	public boolean canAttend(Attraction attraction) {
		return attraction.getDuration() <= this.time;
	}

	public boolean canAfford2(Offer offer) {
		return offer.getCost() <= this.coins;
	}

	public boolean canAttend2(Offer offer) {
		return offer.getDuration() <= this.time;
	}
	
	
	
	
	public boolean checkPassword(String password) {
		// this.password en realidad es el hash del password
		return Crypt.match(password, this.password);
	}

	public Boolean getAdmin() {
		return admin;
	}

	public Integer getCoins() {
		return coins;
	}

	public Integer getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Double getTime() {
		return time;
	}

	public String getUsername() {
		return username;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public boolean isNull() {
		return false;
	}
	
	//Getter para preferencias
		public String getPrefer() {
			return prefer;
		} 
	

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public void setCoins(Integer coins) {
		this.coins = coins;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	//Agrego SeterPreferencias
	public void setPrefer(String prefer) {
		this.prefer = prefer;
	}
	
	//Ordena las atracciones segun dinero y tiempo
	public static void sortAttractionsByCostAndDuration (List<Attraction> attractions) {
		Collections.sort(attractions, new SortedAttractions());		
	}
	
	//ordena las atracciones segun preferencias
	public List<Attraction> sortAttractionsByPrefer(List<Attraction> attrac){
		LinkedList<Attraction> suggest = new LinkedList<Attraction>();
		LinkedList<Attraction> dontMatch = new LinkedList<Attraction>();
		//ordena por Precio y Tiempo
		User.sortAttractionsByCostAndDuration(attrac);

				for (Attraction att : attrac) {
					if (att.getTipe().equals(this.getPrefer())) {
						suggest.add(att);
					}
					else {
						dontMatch.add(att);
					}
				}

				// AGREGA LOS PRODUCTOS QUE NO COINCIDEN AL FINAL DE LA LISTA
				suggest.addAll(dontMatch);

				return suggest;

	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", admin=" + admin + ", prefer=" + prefer+"]";
	}

}
