package persistence;

import model.Itinerari;
import persistence.commons.GenericDAO;

public interface ItinerariDAO extends GenericDAO<Itinerari> {

	public abstract Itinerari findByItinUser(Integer id);
	
}
