package repos;

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
	private String url = "jdbc:sqlserver://SD2310\\SQLExpress;encrypt=false;databaseName=Restaurant;integratedSecurity=true";
	private Connection conn;

	public UserRepository() throws SQLException {

		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");

	}

	public void CloseConnection() throws SQLException {
		conn.close();
	}

	public void ShowOrderDetail() throws SQLException {
		String query1 = "SELECT * FROM OrderDetail";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %s %s %s %s %d", rs.getInt(""), 
					rs.getInt("OrderID"), rs.getInt(""), rs.getInt(""), 
					rs.getInt(""), rs.getInt(""), rs.getString(""), rs.getInt(""));
			System.out.println(cstFmt);
		}
	}
}/*da mahna skobata posle*/

	/*public void InsertOrder(String , String , String , String , String , int , int ) throws SQLException {
		String query1 = "INSERT INTO () " + "VALUES(?,?,?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setString(1, );
		stmt.setString(2, );
		stmt.setString(3, );
		stmt.setString(4, );
		stmt.setString(5, );
		stmt.setInt(6, );
		stmt.setInt(7, );
		
		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));
	}*/

	// shows first name of the customer by id
	/*public void showCustomerById(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "SELECT * FROM User " + "WHERE UserId = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %s %s", rs.getInt("UserId"), rs.getString("FirstName"),
					rs.getString("LastName"), rs.getString("Email"), rs.getString("Username"), rs.getInt("Role"), rs.getInt("ParkingId"));

			System.out.println(cstFmt);
		}
	}*/

// Updates the customers first name by id
	/*public void updateCustomer(int , String , String ) throws SQLException {
		String query1 = "UPDATE  " + "SET  = ?,  = ? " + "WHERE  = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setString(1, );
		stmt.setString(2, );
		stmt.setInt(3, );

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));
	}

	public void deleteCustomer(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "DELETE FROM  " + "WHERE  = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setInt(1, );

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));

	}

	public List<User> GetCustomers() throws SQLException {

		List<User> customers = new ArrayList<User>();
		String query1 = "SELECT TOP 9 * FROM ";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %s %d %d", rs.getInt(""), rs.getString(""),
					rs.getString(""), rs.getString(""), rs.getInt(""), rs.getInt(""));
			System.out.println(cstFmt);
		}
		return customers;
	}

	public List<User> getUsers() {
// TODO Auto-generated method stub
		return null;
	}
}*/