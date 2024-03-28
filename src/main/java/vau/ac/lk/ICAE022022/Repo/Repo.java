package vau.ac.lk.ICAE022022.Repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repo {
	private static final String DB_Driver = "com.mysql.jdbc.Driver";
	private static final String DB_Connection = "jdbc:mysql://localhost:3306/";
	private static final String DB_Name = "socialmedia";
	private static final String DB_User = "root";
	private static final String DB_Password = "";

	public static void getDriver() {
		try {
			Class.forName(DB_Driver);
			System.out.println("Driver found");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found " + e.getMessage());
		}
	}

	public static Connection getDBConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_Connection + DB_Name, DB_User, DB_Password);
			System.out.println("Database connected");
		} catch (SQLException e) {
			System.out.println("Database not connected " + e.getMessage());
		}

		return connection;
	}

	public ResultSet getResultFromTable(Connection connection, String query) {
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return resultSet;
	}

	public void CUDop(Connection connection, String query) {
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public int countRows(Connection connection, String query) {
		Statement statement;
		ResultSet resultSet = null;
		int countRows = 0;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			resultSet.next();
			countRows = resultSet.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return countRows;
	}
}
