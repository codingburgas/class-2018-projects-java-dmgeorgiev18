package repositories;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.User;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;

public class UserRepository {
	private String url = "jdbc:sqlserver://SD2310\\SQLExpress;encrypt=false;databaseName=MotoHotel;integratedSecurity=true";
	private Connection conn;

	public UserRepository() throws SQLException {

		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");

	}

	public void CloseConnection() throws SQLException {
		conn.close();
	}

	public void ShowUser() throws SQLException {
		String selectUserQuery = "SELECT * FROM [User]";

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(selectUserQuery);

			while (rs.next()) {
				String cstFmt = String.format("%d %s %s %s %s %s %d", rs.getInt("UserId"), rs.getString("FirstName"),
						rs.getString("LastName"), rs.getString("Email"), rs.getString("Username"),
						rs.getString("Password"), rs.getInt("ParkingId"));
				System.out.println(cstFmt);
			}
		}
	}

	public void insertUser(String firstName, String lastName, String email, String username, String password,
			int parkingId) throws SQLException {
		String selectUserQuery = "INSERT INTO User(FirstName,LastName,Email,Username,Password,ParkingId) "
				+ "VALUES(?,?,?,?,?,?)";

		try (PreparedStatement stmt = conn.prepareStatement(selectUserQuery)) {

			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, email);
			stmt.setString(4, username);
			stmt.setString(5, password);
			stmt.setInt(6, parkingId);
			int rs = stmt.executeUpdate();

			System.out.println(String.format("Rows affected: %d", rs));
		}

	}


// Updates the customers first name by id
	public void updateUser(String firstName, String lastName, String email, String username, String password,
			int parkingId) throws SQLException {
		String selectUserQuery = "UPDATE User "
				+ "SET FirstName = ?, LastName = ?, Email = ? , UserName = ?,Password = ?,ParkingId = ?"
				+ "WHERE UserId = ?";
		try (PreparedStatement stmt = conn.prepareStatement(selectUserQuery)) {
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, email);
			stmt.setString(4, username);
			stmt.setString(5, password);
			stmt.setInt(6, parkingId);

			int rs = stmt.executeUpdate();

			System.out.println(String.format("Rows affected: %d", rs));
		}
	}

	public void deleteUser(Integer id) throws SQLException {
		String idStr = id.toString();
		String selectUserQuery = "DELETE FROM User + WHERE UserId = ?";

		try (PreparedStatement stmt = conn.prepareStatement(selectUserQuery)) {
			stmt.setInt(1, id);

			int rs = stmt.executeUpdate();

			System.out.println(String.format("Rows affected: %d", rs));
		}
	}

	public List<User> GetUser() throws SQLException {

		List<User> users = new ArrayList<User>();
		String selectUserQuery = "SELECT * FROM [User]";

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(selectUserQuery);

			while (rs.next()) {
				String cstFmt = String.format("%d %s %s %s %s %d", rs.getInt("UserId"), rs.getString("FirstName"),
						rs.getString("LastName"), rs.getString("Email"), rs.getString("Password"),
						rs.getInt("ParkingId"));
				System.out.println(cstFmt);
			}
			return users;
		}
	}
}
