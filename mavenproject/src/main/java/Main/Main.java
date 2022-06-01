package Main;
import static java.nio.charset.StandardCharsets.UTF_8;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import Database.Connecting;



import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
public class Main {



//Main class containing main method, i.e. start of a Java application {
	public static void main(String... args) throws SQLException {
	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, UTF_8));
	//System.out.println(System.getProperty("file.encoding"));



	Connecting database = new Connecting();
	database.showOrder();
	//database.ShowOrderDetail();
	//database.showOrderById(1);
	//database.deleteOrder(1);
	//database.GetOrders();

	//database.ShowOrders();
	}
	}

