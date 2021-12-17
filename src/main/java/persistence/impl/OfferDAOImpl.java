package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.AbsoluteOffer;
import model.Attraction;
import model.AxBOffer;
import model.Offer;
import model.PercentOffer;
import model.PromotoDB;
import persistence.AttractionDAO;
import persistence.OfferDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;

public class OfferDAOImpl implements OfferDAO {

	@Override
	public Offer find(Integer id) {
		try {
			String sql = "SELECT * FROM OFFERS WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Offer offer = null;

			if (resultados.next()) {
				offer = toOffer(resultados);
			}

			return offer;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Offer> findAll() {
		try {
			String sql = "SELECT * FROM OFFERS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Offer> offers = new LinkedList<Offer>();
			while (resultados.next()) {
				offers.add(toOffer(resultados));
			}

			return offers;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	/*
	@Override
	public int insert(Offer t) {
		int rows = 0;

		try {
			String sql = "INSERT INTO OFFERS (offer,name,tipe, atr1, atr2, freeAtr, percDisc, absPrice,description) VALUES (?,?,?,?,?,?,?,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			if (t.getOfferClass().equalsIgnoreCase("AxB")) {
				statement.setString(1, "AxB");
				statement.setString(2, t.getName());
				statement.setString(3, t.getTipe());
				if (t.getAttractionsInclude().size() > 2) {
					statement.setString(4, t.getAttractionsInclude().get(0).getName());
					statement.setString(5, t.getAttractionsInclude().get(1).getName());
					statement.setString(6, t.getAttractionsInclude().get(2).getName());
				} else {
					statement.setString(4, t.getAttractionsInclude().get(0).getName());
					statement.setString(5, null);
					statement.setString(6, t.getAttractionsInclude().get(1).getName());
				}
				statement.setString(7, null);
				statement.setString(8, null);
				statement.setString(9, t.getDescription());
				rows = statement.executeUpdate();
				return rows;
			}

			else if (t.getOfferClass().equalsIgnoreCase("Por")) {
				statement.setString(1, "Por");
				statement.setString(2, t.getName());
				statement.setString(3, t.getTipe());
				if (t.getAttractionsInclude().size() > 1) {
					statement.setString(4, t.getAttractionsInclude().get(0).getName());
					statement.setString(5, t.getAttractionsInclude().get(1).getName());
				} else {
					statement.setString(4, t.getAttractionsInclude().get(0).getName());
					statement.setString(5, null);
				}
				statement.setString(6, null);
				statement.setInt(7, t.getDeductionPercent());
				statement.setString(8, null);
				statement.setString(9, t.getDescription());
				rows = statement.executeUpdate();
				return rows;

			} else if (t.getOfferClass().equalsIgnoreCase("Abs")) {
				statement.setString(1, "Abs");
				statement.setString(2, t.getName());
				statement.setString(3, t.getTipe());
				if (t.getAttractionsInclude().size() > 1) {
					statement.setString(4, t.getAttractionsInclude().get(0).getName());
					statement.setString(5, t.getAttractionsInclude().get(1).getName());
				} else {
					statement.setString(4, t.getAttractionsInclude().get(0).getName());
					statement.setString(5, null);
				}
				statement.setString(6, null);
				statement.setString(7, null);
				statement.setInt(8, t.getCost());
				statement.setString(9, t.getDescription());
				rows = statement.executeUpdate();
				return rows;
			}
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		return rows;
	}*/
	
	
	
	@Override
	public int insert(PromotoDB attraction) {
		System.out.println("offer DAO IMPL");
		try {
			String sql = "INSERT INTO OFFERS (OFFER, NAME, TIPE, ATR1, ATR2, FREEATR,PERCDISC,ABSPRICE,DESCRIPTION) VALUES (?,?,?,?,?,?,?,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			int i = 1;
			statement.setString(i++, attraction.getOfferCLass());
			statement.setString(i++, attraction.getName());
			statement.setString(i++, attraction.getTipe());
			statement.setString(i++, attraction.getAtr1());
			statement.setString(i++, attraction.getAtr2());
			statement.setString(i++, attraction.getFreeatr());
			statement.setInt(i++, attraction.getPercent());
			statement.setInt(i++, attraction.getAbs());
			statement.setString(i++, attraction.getDescription());
			
			int rows = statement.executeUpdate();

			String anularfree = "update offers set freeAtr = NULL where freeAtr = '' ";
			//Connection conn2 = ConnectionProvider.getConnection();
			PreparedStatement statement2 = conn.prepareStatement(anularfree);
			int rows2 = statement2.executeUpdate();
			
			
			return rows;
			
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public int update(Offer t) {
		try {
			String sql = "UPDATE OFFERS SET OFFER = ?, NAME = ?, TIPE = ?, ATR1 = ?, ATR2 = ?, freeAtr = ?, percDisc = ?, AbsPrice = ?, description = ? WHERE ID = ?";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getOfferClass());// offer
			statement.setString(2, t.getName());// name
			statement.setString(3, t.getTipe());// tipe
			statement.setString(4, t.getAttractionsInclude().get(0).getName());// atr1
			statement.setInt(7, t.getDeductionPercent());// percDisc
			statement.setInt(8, t.getAbsolutePrice());// AbsPrice
			statement.setString(9, t.getDescription());// description

			// Si es offer axb y tiene 3 atracciones (1gratis)
			if (t.getOfferClass().equalsIgnoreCase("AxB") && t.getAttractionsInclude().size() > 2) {
				statement.setString(5, t.getAttractionsInclude().get(1).getName());// atr2
				statement.setString(6, t.getAttractionsInclude().get(2).getName());// freeAtr

			}
			// si es offer axb y tiene 2 atracciones (1 gratis)
			else if (t.getOfferClass().equalsIgnoreCase("AxB") && t.getAttractionsInclude().size() < 2) {
				statement.setString(5, null);// atr2
				statement.setString(6, t.getAttractionsInclude().get(2).getName());// freeAtr

			}
			// Si es offer por o abs y tiene 2 atracciones
			else if ((t.getOfferClass().equalsIgnoreCase("Por") || t.getOfferClass().equalsIgnoreCase("Abs"))
					&& t.getAttractionsInclude().size() >= 2) {
				statement.setString(5, t.getAttractionsInclude().get(1).getName());// atr2
				statement.setString(6, null);// freeAtr

			}
			// si es offer por abs y tiene 1 atraccion
			else if ((t.getOfferClass().equalsIgnoreCase("Por") || t.getOfferClass().equalsIgnoreCase("Abs"))
					&& t.getAttractionsInclude().size() < 2) {
				statement.setString(5, null);// atr2
				statement.setString(6, null);// freeAtr
			}

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Offer findByName(String name) {
		try {
			// 15-12 agrego el findbyname que faltaba 
			String sql = "SELECT * FROM offers WHERE name LIKE ?";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet results = statement.executeQuery();
			Offer newOffer = null;

			if (results.next()) {
				newOffer = toOffer(results);
			}

			return newOffer;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Offer toOffer(ResultSet results) throws SQLException {

		// obtengo el tipo de promo
		String offer = results.getString("offer");
		
		//System.out.println(results.getString("offer"));
		
		
		// obtengo el nombre de la promo
		String name = results.getString("name");
		//System.out.println(results.getString("name"));
		
		// Obtengo el tipo de atraccion de la promocion
		String tipe = results.getString("tipe");
		//System.out.println(results.getString("tipe"));
		
		String desc = results.getString("description");
		//System.out.println(results.getString("description"));
		
		int percent = results.getInt("percDisc");
		//System.out.println(results.getString("percDisc"));
		
		
		// creo el objeto para consultar las atracciones dentro de la promo
		AttractionDAO atr = DAOFactory.getAttractionDAO();

		Attraction includedAttraction1 = null;
		Attraction includedAttraction2 = null;
		Attraction freeAttraction = null;

		// declaro el elemento a devolver (la promo)
		Offer newOffer = null;

		/*
		 * Agrega al array de atracciones aquellas incluidas en la Promo las columnas 4
		 * y 5 son las atracciones incluidas si no son nulas se agregan a la lista
		 * atracIncluidas
		 */
		if (results.getString(4) != null) {

			includedAttraction1 = atr.findByName(results.getString("atr1"));

		}
		if (results.getString(5) != null) {

			includedAttraction2 = atr.findByName(results.getString("atr2"));
		}

		// creo las promociones deendiendo su tipo (dado por el dato tipoPromocion)

		if (offer.equalsIgnoreCase("Por")) {

			/*
			 * PromoPorcentual la creo mandando el array atracciones en primer parametro y
			 * el dato del porcentaje de descuento como segundo mas nombre y tipo
			 */
			// "offer,name,tipe, atr1, atr2, freeAtr, percDisc, absPrice,description"
			
			if (includedAttraction2 != null) {
				newOffer = new PercentOffer(results.getInt("id"), name, desc, tipe, includedAttraction1,
						includedAttraction2, percent);
			} else {
				newOffer = new PercentOffer(results.getInt("id"), name, desc, tipe, includedAttraction1, percent);
			}

		} else if (offer.equalsIgnoreCase("AxB")) {

			/*
			 * PromoPorcentual la creo mandando el array atracciones en primer parametro y
			 * la atraccion que es gratuita en segunobdo mas nombre y tipo
			 */
			Attraction attrAxB = atr.findByName(results.getString("freeAtr"));
			//System.out.println("Creo promo AXB");
			if (includedAttraction2 != null) {
				newOffer = new AxBOffer(results.getInt("id"), name, desc, tipe, includedAttraction1,
						includedAttraction2, attrAxB);
				
			} else {
				newOffer = new AxBOffer(results.getInt("id"), name, desc, tipe, includedAttraction1, attrAxB);
		
			}

		} else if (offer.equalsIgnoreCase("Abs")) {
			/*
			 * PromoPorcentual la creo mandando el array atracciones en primer parametro y
			 * el dato del costo final obtenido del archivo mas nombre y tipo
			 */
			Integer absolutePrice = results.getInt("absPrice");
			
			if (includedAttraction2 != null) {
				newOffer = new AbsoluteOffer(results.getInt("id"), name, desc, tipe, includedAttraction1,
						includedAttraction2, absolutePrice);
			} else {
				newOffer = new AbsoluteOffer(results.getInt("id"), name, desc, tipe, includedAttraction1,
						absolutePrice);
			}
		}

		// Agrego la promo a la lista de productos

		return newOffer;
		
		
	}
	
	
	

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM OFFERS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Offer offer) {
		try {
			String sql = "DELETE FROM offers WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, offer.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Offer t) {
		// TODO Auto-generated method stub
		return 0;
	}
}