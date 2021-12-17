package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import persistence.AttractionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class AttractionDAOImpl implements AttractionDAO {

	public List<Attraction> findAll() {
		try {
			String sql = "SELECT * FROM ATTRACTIONS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Attraction> attractions = new LinkedList<Attraction>();
			while (resultados.next()) {
				attractions.add(toAttraction(resultados));
			}

			return attractions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Attraction find(Integer id) {
		try {
			String sql = "SELECT * FROM ATTRACTIONS WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Attraction attraction = null;
			
			if (resultados.next()) {
				attraction = toAttraction(resultados);
			}

			return attraction;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	//DIEGO 15-12 AGREGO EL FINDBYNAME QUE REQUIERE OFFERDAROIMPL
	@Override
	public Attraction findByName(String name) {
		try {
			String sql = "SELECT * FROM ATTRACTIONS WHERE name = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet resultados = statement.executeQuery();

			Attraction attraction = null;
			
			if (resultados.next()) {
				attraction = toAttraction(resultados);
			}

			return attraction;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	
	
	
	
	
	private Attraction toAttraction(ResultSet attractionRegister) throws SQLException {
		return new Attraction(
				attractionRegister.getInt(1), 
				attractionRegister.getString(2),
				attractionRegister.getInt(3), 
				attractionRegister.getDouble(4), 
				attractionRegister.getInt(5),
				//Agrego 3 campos nuevos
				attractionRegister.getString(6),
				attractionRegister.getString(7),
				attractionRegister.getString(8));
	}

	@Override
	public int insert(Attraction attraction) {
		try {
			String sql = "INSERT INTO ATTRACTIONS (NAME, COST, DURATION, CAPACITY, TIPE, DESCRIPTION, IMAGE) VALUES (?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, attraction.getName());
			statement.setInt(i++, attraction.getCost());
			statement.setDouble(i++, attraction.getDuration());
			statement.setInt(i++, attraction.getCapacity());
			statement.setString(i++, attraction.getTipe());
			statement.setString(i++, attraction.getDescription());
			statement.setString(i++, attraction.getImage());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Attraction attraction) {
		try {
			String sql = "UPDATE ATTRACTIONS SET NAME = ?, COST = ?, DURATION = ?, CAPACITY = ?, TIPE = ?, DESCRIPTION = ?, IMAGE = ? WHERE ID = ?";
			
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, attraction.getName());
			statement.setInt(i++, attraction.getCost());
			statement.setDouble(i++, attraction.getDuration());
			statement.setInt(i++, attraction.getCapacity());
			
			//Agrego estos tres
			statement.setString(i++, attraction.getTipe());
			statement.setString(i++, attraction.getDescription());
			statement.setString(i++, attraction.getImage());
			
			statement.setInt(i++, attraction.getId());
			
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Attraction attraction) {
		try {
			String sql = "DELETE FROM ATTRACTIONS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, attraction.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM ATTRACTIONS";
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



}
