package persistence.commons;

import persistence.AttractionDAO;
import persistence.UserDAO;
import persistence.ItinerariDAO;
import persistence.impl.AttractionDAOImpl;
import persistence.impl.ItinDAOImpl;
import persistence.impl.UserDAOImpl;

public class DAOFactory {

	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}
	
	public static AttractionDAO getAttractionDAO() {
		return new AttractionDAOImpl();
	}
	
	public static ItinerariDAO getItinerariDAO() {
		return new ItinDAOImpl();
	}
	
}
