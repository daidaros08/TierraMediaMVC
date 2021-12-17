package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Attraction;
import model.Itinerari;
import model.User;
import persistence.AttractionDAO;
import persistence.ItinerariDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class BuyOfferService {

	AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
	
	UserDAO userDAO = DAOFactory.getUserDAO();
	//Diego 11-12 agrego para que actualize itinerario
	ItinerariDAO itinDAO = DAOFactory.getItinerariDAO();
	
	
	public Map<String, String> buy(Integer userId, Integer attractionId) {
		Map<String, String> errors = new HashMap<String, String>();

		User user = userDAO.find(userId);
		
		Attraction attraction = attractionDAO.find(attractionId);
		//Creo un itinerario con el id y el att id
		Itinerari itin=new Itinerari(user.getId(),attraction.getId());
		//Creo una lista itinerario con el user Id
		List<Itinerari> itinerari = itinDAO.findById(userId);

		//if (itin.yaExiste(userId,List<Itinerari>);
			
		
		
		if (!attraction.canHost(1)) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!user.canAfford(attraction)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.canAttend(attraction)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.addToItinerary(attraction);
			attraction.host(1);

			// no grabamos para no afectar la base de pruebas
			attractionDAO.update(attraction);
			userDAO.update(user);
			
			//Diego 11-10 Creo un Itinerario y lo envio al insertdao
			
			//Itinerari itin=new Itinerari(user.getId(),attraction.getId());
			
			itinDAO.insert(itin);
		}

		return errors;

	}

}
