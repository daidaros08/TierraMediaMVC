package persistence;

import java.util.List;

import model.Itinerari;
import persistence.commons.GenericDAO;

public interface ItinerariDAO extends GenericDAO<Itinerari> {

	//public abstract Itinerari findById(Integer id);
	
	public abstract List<Itinerari> findById(Integer id);
	
	
}
