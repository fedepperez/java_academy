package day_17.jdbc.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import day_17.jdbc.model.Persona;
import day_17.jdbc.persistence.DAOException;
import day_17.jdbc.persistence.DBUtil;
import day_17.jdbc.persistence.DataSource;
import day_17.jdbc.persistence.PersonaDAO;
import day_17.jdbc.persistence.impl.PersonaDAOImpl;

public class PersonaDAOImpl implements PersonaDAO {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss");

	public void save(Persona persona) throws DAOException {

		String SQL = "INSERT INTO Persona (CF, nome, cognome, data_nascita) VALUES (?, ?, ?, ?)";

		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL, new String[] { "id" });
			statement.setString(1, persona.getCF());
			statement.setString(2, persona.getNome());
			statement.setString(3, persona.getCognome());
			statement.setTimestamp(4, Timestamp.valueOf(persona.getDataNascita()));
			statement.executeUpdate();
			ResultSet generateKeys = statement.getGeneratedKeys();
			if (generateKeys.next()) {
				persona.setId(generateKeys.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
			DBUtil.close(connection);
		}

	}

	public Persona findById(int id) throws DAOException {
		String SQL = "SELECT * FROM persona WHERE id = ?";
		System.out.println(SQL);
		Persona persona = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				persona = new Persona(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getTimestamp(5).toLocalDateTime());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return persona;
	}

	@Override
	public void update(Persona persona) throws DAOException {
		String SQL = "UPDATE persona SET CF = ?,  nome = ? , cognome = ?, data_nascita = ? WHERE id = ?";
		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			statement.setString(1, persona.getCF());
			statement.setString(2, persona.getNome());
			statement.setString(3, persona.getCognome());
			statement.setTimestamp(4, Timestamp.valueOf(persona.getDataNascita()));
			statement.setInt(5, persona.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
	}

	public void delete(int id) throws DAOException {
		String SQL = "DELETE FROM persona WHERE id = ?";
		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
	}

	public Persona findByCF(String CF) throws DAOException {
		String SQL = "SELECT * FROM persona WHERE CF = ?";
		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Persona persona = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			statement.setString(1, CF);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				persona = new Persona(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getTimestamp(5).toLocalDateTime());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return persona;
	}

	public List<Persona> findAll() throws DAOException {
		List<Persona> persone = new ArrayList<>();
		String SQL = "SELECT * FROM persona";
		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Persona persona = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				persona = new Persona(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getTimestamp(5).toLocalDateTime());
				persone.add(persona);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return persone;
	}

	public List<Persona> findByNome(String nome) throws DAOException {
		List<Persona> persone = new ArrayList<>();
		String SQL = "SELECT * FROM persona WHERE nome = ?";
		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Persona persona = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			statement.setString(1, nome);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				persona = new Persona(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getTimestamp(5).toLocalDateTime());
				persone.add(persona);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return persone;
	}

	public List<Persona> findByCognome(String cognome) throws DAOException {
		List<Persona> persone = new ArrayList<>();
		String SQL = "SELECT * FROM persona WHERE cognome = ?";
		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Persona persona = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			statement.setString(1, cognome);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				persona = new Persona(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getTimestamp(5).toLocalDateTime());
				persone.add(persona);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return persone;
	}

	public List<Persona> findByAnno(String annoNascita) throws DAOException {
		List<Persona> persone = new ArrayList<>();
		String SQL = "SELECT * FROM persona WHERE year(data_nascita) = ?";
		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Persona persona = null;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			statement.setString(1, annoNascita);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				persona = new Persona(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getTimestamp(5).toLocalDateTime());
				persone.add(persona);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return persone;
	}

	public long count() throws DAOException {
		String SQL = "SELECT COUNT(*) FROM persona";
		System.out.println(SQL);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		long count = 0;
		try {
			connection = DataSource.getConnection();
			statement = connection.prepareStatement(SQL);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return count;
	}

}
