package services;

import java.util.List;

import model.AbsoluteOffer;
import model.AxBOffer;
import model.Offer;
import model.PercentOffer;
import model.PromotoDB;
import persistence.ItinerariDAO;
import persistence.OfferDAO;
import persistence.commons.DAOFactory;

public class OfferService {

	public List<Offer> list() {
		
		return DAOFactory.getOfferDAO().findAll();
		
	}
	

	public PromotoDB create(Integer id, String classOffer,String name,String tipe, 
			String atr1, String atr2, String freeatr, 
			Integer percent, Integer dtoabs,
			String description) {

		PromotoDB offer = new PromotoDB (1, classOffer, name, tipe, atr1, atr2, freeatr, percent, dtoabs , description);

		OfferDAO offerDAO = DAOFactory.getOfferDAO();
		
		offerDAO.insert(offer);
		System.out.println("offer Service");
	return offer;
		
		
	}
		/*
		
		
		
		
		
		
		
		//if (offer.isValid()) {
		
			OfferDAO offerDAO = DAOFactory.getOfferDAO();
			
			offerDAO.insert(offer);
			
			// XXX: si no devuelve "1", es que hubo más errores
		//}

		return offer;
	}*/

	
	/*
	public Attraction update(Integer id, String name, Integer cost,
			Double duration, Integer capacity,
			String tipe, String description, String image) {

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Attraction attraction = attractionDAO.find(id);

		attraction.setName(name);
		attraction.setCost(cost);
		attraction.setDuration(duration);
		attraction.setCapacity(capacity);
		attraction.setTipe(tipe);
		attraction.setDescription(description);
		attraction.setImage(image);
		
		
		
		if (attraction.isValid()) {
			attractionDAO.update(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	*/

	public void delete(Integer id, String tipo) {
		OfferDAO offerDAO = DAOFactory.getOfferDAO();
		
		if(tipo.equals("AxB")) {
			Offer offer = new AxBOffer(id, null, null, null, null, null, null);
			offerDAO.delete(offer);
		}
		
		if(tipo.equals("Por")) {
			Offer offer = new PercentOffer(id, null, null, null, null, null, null);
			offerDAO.delete(offer);
		}
		
		if(tipo.equals("Abs")) {
			Offer offer = new AbsoluteOffer(id, null, null, null, null, null, null);
			offerDAO.delete(offer);
		}

	}

	
	/*
	public Attraction find(Integer id) {
		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		return attractionDAO.find(id);
	} */

}
