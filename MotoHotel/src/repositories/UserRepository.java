package repositories;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.User;

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

	
	public User login(User username, String password) throws SQLException {

		String selectUserQuery = "SELECT * FROM [Users] " + "WHERE Username = '" + username + "';";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectUserQuery);

		while (rs.next()) {
			if (rs.getString("Password").equals("password")) {
				username = new User(Long.parseLong(rs.getString("UserId")), rs.getString("UserId"), rs.getString("UserId"));
				System.out.println("YOU HAVE LOGGED IN SUCCESSFULLY");
				return username;
				
				
			}
		}
		return null;
	}

	public void ShowUsers() throws SQLException {
		String selectUserQuery = "SELECT * FROM Users";

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
		String selectUserQuery = "INSERT INTO [dbo].[Users] (FirstName, LastName, Email, Username, Password, ParkingId) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(selectUserQuery);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, email);
			stmt.setString(4, username);
			stmt.setString(5, password);
			stmt.setInt(6, parkingId);

			stmt.executeUpdate();
			System.out.println("User has been registered.");
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

// Updates the customers first name by id

	// Remove the comment in userdata

	public void updateUser(int id, String firstName, String lastName, String email, String username, String password)
			throws SQLException {
		String selectUserQuery = "UPDATE [Users] SET FirstName = ?, LastName = ?, Email = ? , Username = ?,Password = ?"
				+ "WHERE UserId = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(selectUserQuery);

			stmt.setInt(1, id);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, email);
			stmt.setString(5, username);
			stmt.setString(6, password);

			int rs = stmt.executeUpdate();

			System.out.println("User has been updated.");
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	public void deleteUser(int id) throws SQLException {
		String selectUserQuery = "DELETE FROM [Users] " + "WHERE UserId = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(selectUserQuery);
			stmt.setInt(1, id);
			int rs = stmt.executeUpdate();
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}
}
