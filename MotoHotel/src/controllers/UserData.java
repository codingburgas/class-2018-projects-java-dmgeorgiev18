package controllers;

import java.sql.SQLException;
import java.util.Scanner;

import repositories.UserRepository;

public class UserData {
	Scanner scanner = new Scanner(System.in);

	void insertUser() throws SQLException {
		UserRepository database = new UserRepository();

		System.out.print("First Name --> ");
		String firstName = scanner.nextLine();
		System.out.print("Last Name --> ");
		String lastName = scanner.nextLine();
		System.out.print("Email --> ");
		String email = scanner.nextLine();

		int flag = 1;
		while (flag == 1) {
			if (email.endsWith("@gmail.com") || email.endsWith("@abv.bg") || email.endsWith("@codingburgas.bg")
					|| email.endsWith("@yahoo.com")) {
				
			} else {
				System.out.print("Invlid Email. Try Again!");
				flag = 0;
			}
			System.out.print("Username --> ");
			String username = scanner.nextLine();
			System.out.print("Password --> ");
			String password = scanner.nextLine();
			System.out.print("Parking ID --> ");
			int parkingId = Integer.parseInt(scanner.nextLine());
			database.insertUser(firstName, lastName, email, username, password, parkingId);
		}
	}

	void AdminMenuCheck() throws SQLException {
		UserRepository database = new UserRepository();

		System.out.println("Username--> ");
		String username = scanner.nextLine();
		System.out.println("Password--> ");
		String password = scanner.nextLine();
		if (username.equals("dmgeorgiev18") && password.equals("27102004dg")) {
			boolean isAdmin = true;

		} else {
			System.out.println("Wrong admin username or password.Try Again!");
		}
	}

	// remove the comments in useservicece
	void updateUserInfo() throws SQLException {

		UserRepository database = new UserRepository();
		System.out.print("UserId --> ");
		int userId = Integer.parseInt(scanner.nextLine());
		System.out.print("First Name --> ");
		String firstName = scanner.nextLine();
		System.out.print("Last Name --> ");
		String lastName = scanner.nextLine();
		System.out.print("Email --> ");
		String email = scanner.nextLine();
		System.out.print("Username --> ");
		String username = scanner.nextLine();
		System.out.print("Password --> ");
		String password = scanner.nextLine();
		database.updateUser(userId, firstName, lastName, email, username, password);
	}

	void deleteUser() throws SQLException {
		UserRepository database = new UserRepository();
		System.out.print("UserId --> ");
		int userId = Integer.parseInt(scanner.nextLine());
		System.out.print("Successfully deleted user with id " + userId + "!");
	}

}
