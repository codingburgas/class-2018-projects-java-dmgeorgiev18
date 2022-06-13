package controllers;

import java.sql.SQLException;
import java.util.Scanner;

import repositories.UserRepository;

public class UserData {
	Scanner scanner = new Scanner(System.in);

	void insertUser() throws SQLException {
		UserRepository database = new UserRepository();

		System.out.print("First Name -> ");
		String firstName = scanner.nextLine();
		System.out.print("Last Name -> ");
		String lastName = scanner.nextLine();
		System.out.print("Email -> ");
		String email = scanner.nextLine();
		System.out.print("Username -> ");
		String username = scanner.nextLine();
		System.out.print("Password -> ");
		String password = scanner.nextLine();
		System.out.print("Parking ID -> ");
		int parkingId = Integer.parseInt(scanner.nextLine());
		database.insertUser(firstName, lastName, email, username, password, parkingId);
	}

	
	//remove the comments in useservicece
	/*void updateUserInfo() throws SQLException {

		UserRepository database = new UserRepository();
		System.out.print("First Name -> ");
		String firstName = scanner.nextLine();
		System.out.print("Last Name -> ");
		String lastName = scanner.nextLine();
		System.out.print("Email -> ");
		String email = scanner.nextLine();
		System.out.print("Username -> ");
		String username = scanner.nextLine();
		System.out.print("Password -> ");
		String password = scanner.nextLine();
		System.out.print("Parking ID -> ");
		int parkingId = Integer.parseInt(scanner.nextLine());
		database.updateUser(firstName, lastName, email, username, password, parkingId);
	}*/
}
