package day_17.jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import day_17.jdbc.model.Persona;

public class DAOException01 {

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
			throw new DAOException("Errore durante la ricerca per ID", e);
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}

		return persona;
	}
}
