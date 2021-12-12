package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Itinerari;
import persistence.ItinerariDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ItinDAOImpl implements ItinerariDAO {

	public int insert(Itinerari itinerari) {
		try {
			//Diego 12-10 modifique la consulta sino daba error al insertar
			String sql = "INSERT INTO ITINERARI (ID_USER, ID_ATTRACTION) VALUES (?,?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, itinerari.getId_user());
			statement.setInt(2, itinerari.getId_attraction());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Itinerari itinerari) {
		
		try {
			String sql = "UPDATE ITINERARI SET ID_USER=?, ID_ATTRACTION=? WHERE ID_ITINERARI = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, itinerari.getId_user());
			statement.setInt(2, itinerari.getId_attraction());
			statement.setInt(3, itinerari.getId_itinerari());
			
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	

	public int delete(Itinerari itinerari) {
		try {
			String sql = "DELETE FROM ITINERARI WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, itinerari.getId_itinerari());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	
	public Itinerari find(Integer id) {
		try {
			String sql = "SELECT * FROM ITINERARI WHERE ID_USER = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Itinerari itinerari = null;

			if (resultados.next()) {
				itinerari = toItinerari(resultados);
			}

			return itinerari;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Itinerari> findAll() {
		try {
			//String sql = "SELECT * FROM ITINERARI";
			String sql = "select id_attraction, id_user, id_attraction, name, cost, duration from itinerari cross join attractions on id_attraction = id";
			
			Connection conn = ConnectionProvider.getConnection();
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			ResultSet resultados = statement.executeQuery();
			
		
			
			List<Itinerari> itinerari = new LinkedList<Itinerari>();
			
			while (resultados.next()) {
				
				itinerari.add(toItinerari(resultados));
				
			}
			
			return itinerari;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	
	
	public List<Itinerari> findById(Integer id) {
		
		try {
			
			//String sql = "SELECT * FROM ITINERARI";
			String sql = "select id_attraction, id_user, id_attraction, name, cost, duration from itinerari cross join attractions on id_attraction = id where id_user=?";
			
			Connection conn = ConnectionProvider.getConnection();
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			ResultSet resultados = statement.executeQuery();

			
			List<Itinerari> itinerari = new LinkedList<Itinerari>();
			
			while (resultados.next()) {
				
				itinerari.add(toItinerari(resultados));
				
			}
			
			return itinerari;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private Itinerari toItinerari(ResultSet itinRegister) throws SQLException {

		return new Itinerari(
				itinRegister.getInt(1),
				itinRegister.getInt(2), 
				itinRegister.getInt(3),
				itinRegister.getString(4),
				itinRegister.getInt(5),
				itinRegister.getDouble(6)
				);
				
	}



	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}




}
