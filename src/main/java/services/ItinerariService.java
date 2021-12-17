package services;

import java.util.ArrayList;
import java.util.List;

import model.Attraction;
import model.Itinerari;
import model.User;
import persistence.AttractionDAO;
import persistence.ItinerariDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class ItinerariService {
	
	public List<Itinerari> list(Integer Id) {
	
		//List <Itinerari> auxiliar = new ArrayList<Itinerari>();
		
		//auxiliar.add(DAOFactory.getItinerariDAO().findById(Id));
		
		//12-10 aca hay que cambiar para que tome solo el id del 
		//usuario que compro
		
		//return DAOFactory.getItinerariDAO().findAll();
		
		return DAOFactory.getItinerariDAO().findById(Id);
		
		//return auxiliar;
	}
	
	
	public Itinerari create(Integer id_itinerari, Integer id_usuario, Integer id_attraction, String name, Integer cost, Double duration) {

		Itinerari itinerari = new Itinerari(id_itinerari,id_usuario, id_attraction, name, cost, duration);
	
		ItinerariDAO itinerariDAO = DAOFactory.getItinerariDAO();
		
		itinerariDAO.insert(itinerari);
		
	return itinerari;
	

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
