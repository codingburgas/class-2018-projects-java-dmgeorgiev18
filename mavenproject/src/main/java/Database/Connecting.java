package Database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Connecting {
	private String url = "jdbc:sqlserver://.\\sqlexpress;databaseName=Restaurant;integratedSecurity=true";
	private Connection conn;

	public Connecting() throws SQLException {
		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");
	}

	public void CloseConnecton() throws SQLException {
		conn.close();
	}

	public void addOrder(Integer OrderID, Float TotalPrice, Integer tableNumber) throws SQLException {
		String query1 = String.format("INSERT INTO Order ([OrderID] ,[TotalPrice],[tableNumber])" + "VALUES (?,?,?)");
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setInt(1, OrderID);
		stmt.setFloat(2, TotalPrice);
		stmt.setInt(3, tableNumber);
		int rs = stmt.executeUpdate();
		if (rs == 1) {
			System.out.println(rs);
		}
	}

	public void showOrder() throws SQLException {
		String query1 = "SELECT * FROM Order";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {

			String custFmt = String.format("%d %s %s %s %s", rs.getInt("OrderID"), rs.getFloat("totalPrice"),
					rs.getInt("tableNumber"));

			System.out.println(custFmt);

		}
	}

// shows the title of the book with id "id"
	public void showOrderByID(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "SELECT * FROM Order " + "WHERE OrderID = " + idStr;
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {

			String custFmt = String.format("%d %s %s %s %s", rs.getInt("OrderID"), rs.getFloat("TotalPrice"),
					rs.getInt("tableNumber"));

			System.out.println(custFmt);
		}
	}

// update the first name of the customer with id "id"
	public void updateOrder(int id, float totalPrice, int tableNumber) throws SQLException {
		String query1 = "UPDATE Item " + "SET tableNumber = ?, totalPrice = ? " + " WHERE = OrderID? ";
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setInt(1, tableNumber);
		stmt.setFloat(2, totalPrice);
		stmt.setInt(3, id);

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));
	}

	public void deleteOrder(Integer id) throws SQLException {
		String query1 = "DELETE FROM Order " + " WHERE OrderID = ? ";
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setInt(1, id);
		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));

	}

}