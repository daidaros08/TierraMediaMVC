package services;

import java.util.List;

import model.Attraction;
import model.Itinerari;
import model.User;
import persistence.AttractionDAO;
import persistence.ItinerariDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class ItinerariService {

	public List<Itinerari> list() {
		return DAOFactory.getItinerariDAO().findAll();
	}
	
	public Itinerari create(Integer id_itinerari, Integer id_usuario, Integer id_attraction) {

		Itinerari itinerari = new Itinerari(id_itinerari,id_usuario, id_attraction);
	
		ItinerariDAO itinerariDAO = DAOFactory.getItinerariDAO();
		itinerariDAO.insert(itinerari);

	return itinerari;
	

	}
	
	//Este metodos hay que cambiarlo
	public User update(Integer id, String username,
			String password, 
			boolean admin, Integer coins, double time,
			String prefer) {

		UserDAO userDAO = DAOFactory.getUserDAO();
		User user = userDAO.find(id);

		user.setUsername(username);
		user.setPassword(password);
		user.setAdmin(admin);
		user.setCoins(coins);
		user.setTime(time);
		user.setPrefer(prefer);
		
		userDAO.update(user);
		/*
		if (user.isValid()) {
			userDAO.update(user);
			// XXX: si no devuelve "1", es que hubo más errores
		}*/

		return user;
	}
	
	
	
	public Itinerari find(Integer id) {
		ItinerariDAO itinerariDAO = DAOFactory.getItinerariDAO();
		return itinerariDAO.find(id);
	}
	
	
	
	
	
	
	
	
	
	


	public Attraction update(Integer id, String name, Integer cost, Double duration, Integer capacity) {

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Attraction attraction = attractionDAO.find(id);

		attraction.setName(name);
		attraction.setCost(cost);
		attraction.setDuration(duration);
		attraction.setCapacity(capacity);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public void delete(Integer id) {
		User user = new User(id, null, null, null, null, null, null);

		UserDAO userDAO = DAOFactory.getUserDAO();
		userDAO.delete(user);
	}

	/*public Attraction find(Integer id) {
		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		return attractionDAO.find(id);
	}*/



}
