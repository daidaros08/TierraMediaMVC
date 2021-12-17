package persistence;

import model.Offer;
import model.PromotoDB;
import persistence.commons.GenericDAO;

public interface OfferDAO extends GenericDAO<Offer> {

	//Esto se agrego verrrrrrr
	int insert(PromotoDB attraction);

}
