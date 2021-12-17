package services;

import java.util.List;

import model.Attraction;
import model.User;
import persistence.AttractionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class UserService {

	public List<User> list() {
		return DAOFactory.getUserDAO().findAll();
	}
	
	//Agrego metodo para crear usuario
	
	public User create(Integer id, String username,
			String password, boolean admin,
			Integer coins, double time,
			String prefer) {

		User user = new User(id, username,password,coins,time,admin,prefer);
	
		UserDAO userDAO = DAOFactory.getUserDAO();
		
		userDAO.insert(user);

	return user;
	

	}
	
	
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
		System.out.println(user.getPassword());
		userDAO.update(user);
		/*
		if (user.isValid()) {
			userDAO.update(user);
			// XXX: si no devuelve "1", es que hubo más errores
		}*/

		return user;
	}
	
	
	
	public User find(Integer id) {
		UserDAO userDAO = DAOFactory.getUserDAO();
		return userDAO.find(id);
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
